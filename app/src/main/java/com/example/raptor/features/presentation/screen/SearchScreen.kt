package com.example.raptor.features.presentation.screen

import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.raptor.features.presentation.component.ProductItem
import com.example.raptor.features.presentation.viewModel.ProductViewModel
import kotlin.math.log

@Composable
fun SearchScreen(navController: NavController) {
    val viewModel: ProductViewModel = ProductViewModel()
    val productList by viewModel.productList.collectAsState()
    val colorOffWhite = Color(0xFF9C8F80)
    val colorGrey = androidx.compose.ui.graphics.Color.White

    val gradientGreenRed = Brush.verticalGradient(0f to colorGrey, 1000f to colorOffWhite)

    var searchQuery by remember { mutableStateOf("") }
    Column(verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.background(gradientGreenRed)) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

//        if (filteredProducts.isEmpty()){
//            Text(text = "No items Found")
//        }
//        else {

            LazyVerticalGrid(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
                columns = GridCells.Fixed(2),
            ) {

                val filteredProducts = productList.filter { product ->
                    product?.title!!.contains(searchQuery, ignoreCase = true) ||
//                            product.description.contains(searchQuery, ignoreCase = true) ||
                            product.category.contains(searchQuery, ignoreCase = true)
                }


                items(filteredProducts.size) {
                    ProductItem(product = filteredProducts[it], onItemClick = ({ it ->


                        val productId = filteredProducts[it]?.id
                        val title = filteredProducts[it]?.title
                        val price = filteredProducts[it]?.price
                        val description = filteredProducts[it]?.description
                        val category = filteredProducts[it]?.category
                        val image = filteredProducts[it]?.image
                        //val rating= product[it]?.rating?.rate
                        val route =
                            "ProductDetailScreen?productId=$productId&title=$title&price=$price&description=$description&category=$category&image=$image"
                        navController.navigate(route)
                    }
                            ))
                }
            }
        }
    }
