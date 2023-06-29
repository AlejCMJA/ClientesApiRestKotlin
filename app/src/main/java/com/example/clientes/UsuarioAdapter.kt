package com.example.clientes


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class UsuarioAdapter(
    var context: Context,
    var listausuarios: ArrayList<Usuario>
): RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_usuario, parent, false)
        return UsuarioViewHolder(vista)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = listausuarios.get(position)

//        holder.tvidUusario.text = usuario.idUsuario.toString()

        holder.tvEdad.text = "Edad = ${usuario.edad.toString()}"
        holder.tvNombre.text = "Nombre = ${usuario.nombre}"
        holder.tvEmail.text = "Correo Electrónico = ${usuario.email}"
        holder.tvTelefhone.text = "Número de Teléfono = ${usuario.telephone}"
        holder.tvDirection.text = "Dirección = ${usuario.direction}"
        holder.tvCedula.text = "Identificación = ${usuario.cedula}"
    }

    override fun getItemCount(): Int {
        return listausuarios.size
    }
    fun actualizarLista(nuevaListaUsuarios: ArrayList<Usuario>) {
        listausuarios = nuevaListaUsuarios
        notifyDataSetChanged()
    }
    inner class UsuarioViewHolder(itemView: View): ViewHolder(itemView) {
//        val tvIdUsuario = itemView.findViewById(R.id.tvIdUsuario) as TextView
        val tvEdad = itemView.findViewById(R.id.tvEdad) as TextView
        val tvNombre = itemView.findViewById(R.id.tvNombre) as TextView
        val tvEmail = itemView.findViewById(R.id.tvEmail) as TextView
        val tvTelefhone = itemView.findViewById(R.id.tvTelephone) as TextView
        val tvDirection = itemView.findViewById(R.id.tvDirection) as TextView
        val tvCedula = itemView.findViewById(R.id.tvCedula) as TextView
    }
}