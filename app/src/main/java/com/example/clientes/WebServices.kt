package com.example.clientes

import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

object AppConstantes {
    const val BASE_URL = "http://10.0.2.2:8000/api/"
}

interface WebServices {
    @GET("usuarios")
    suspend fun obtenerUsuarios(): Response<UsuariosResponse>
}

object RetrofitClient {
    val webService: WebServices by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebServices::class.java)
    }
}