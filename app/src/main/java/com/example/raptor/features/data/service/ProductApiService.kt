package com.example.raptor.features.data.service

import com.example.raptor.features.data.model.ProductData
import com.example.raptor.features.data.model.ProductList
import retrofit2.http.GET
import retrofit2.http.Url

interface ProductApiService {
    @GET
    suspend fun fetchProductList(
        @Url url: String
    ):List<ProductData>
}
