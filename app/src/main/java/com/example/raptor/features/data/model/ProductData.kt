package com.example.raptor.features.data.model

data class ProductData(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating
)

data class Rating(
    val rate: Double,
    val count: Int
)
data class ProductList(
    val productList:List<ProductData>
)