package com.example.clientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clientes.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var adatador: UsuarioAdapter

    var listaUsuarios = arrayListOf<Usuario>()


    //var usuario = Usuario(-1, "","", "", "", "", "")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsuarios.layoutManager = LinearLayoutManager(this)
        setupRecyclerView()

        obtenerUsuarios()

        val etBusqueda = binding.etBusqueda
        val btnBuscar = binding.btnBuscar

        btnBuscar.setOnClickListener {
            val nombreBusqueda = etBusqueda.text.toString()
            buscarPorNombre(nombreBusqueda)
        }
    }


    fun setupRecyclerView() {
        adatador = UsuarioAdapter(this, listaUsuarios)
        binding.rvUsuarios.adapter = adatador

    }

    fun obtenerUsuarios() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitClient.webService.obtenerUsuarios()
            runOnUiThread {
                if (call.isSuccessful) {
                    listaUsuarios = call.body()!!.listaUsuarios
                    setupRecyclerView()
                } else {
                    Toast.makeText(this@MainActivity, "ERROR CONSULTAR TODOS", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun buscarPorNombre(nombre: String) {
        val resultados = ArrayList<Usuario>()

        for (usuario in listaUsuarios)
        {
            if (usuario.nombre.contains(nombre, ignoreCase = true))
            {
                    resultados.add(usuario)
            }
        }

        adatador.actualizarLista(resultados)
    }
}