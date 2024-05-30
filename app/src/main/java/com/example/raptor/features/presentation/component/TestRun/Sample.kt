@file:OptIn(ExperimentalFoundationApi::class)

package com.example.raptor.features.presentation.component.TestRun

import android.graphics.Color
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text2.input.rememberTextFieldState
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

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.raptor.features.presentation.component.ProductItem
import com.example.raptor.features.presentation.viewModel.ProductViewModel


@Composable
fun ProductGridSample(navController: NavController) {
    val viewModel: ProductViewModel = ProductViewModel()
    val productList by viewModel.productList.collectAsState()
    val colorOffWhite = Color.YELLOW

    var searchQuery by remember { mutableStateOf("") }
    Column(verticalArrangement = Arrangement.SpaceBetween,) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search") },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
        )

        LazyVerticalGrid(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
            columns = GridCells.Fixed(1),
        ) {
            // Filtered products based on search query
            val filteredProducts = productList.filter { product ->
                product?.title!!.contains(searchQuery, ignoreCase = true) ||
                        product.description.contains(searchQuery, ignoreCase = true) ||
                        product.category.contains(searchQuery, ignoreCase = true)
            }

            items(filteredProducts.size) {
                ProductItem(product = filteredProducts[it], onItemClick = ({
                    val s=it
                    val productId = filteredProducts[s]?.id
                    val title = filteredProducts[s]?.title
                    val price= filteredProducts[s]?.price
                    val description= filteredProducts[s]?.description
                    val category= filteredProducts[s]?.category
                    val image= filteredProducts[s]?.image
                    //val rating= product[it]?.rating?.rate
                    val route = "ProductDetailScreen?productId=$productId&title=$title&price=$price&description=$description&category=$category&image=$image"
                    navController.navigate(route)
                }))
            }
        }
    }
}
