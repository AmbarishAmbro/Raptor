package com.example.raptor.core.remote

import com.example.raptor.features.data.service.ProductApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://fakestoreapi.com/"
    val api: ProductApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ProductApiService::class.java)
    }
}