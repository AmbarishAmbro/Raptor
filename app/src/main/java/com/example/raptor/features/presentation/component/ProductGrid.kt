package com.example.raptor.features.presentation.component

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.raptor.features.data.model.Rating
import com.example.raptor.features.presentation.viewModel.ProductViewModel

@Composable
fun ProductGrid(navController: NavController) {
    val viewModel: ProductViewModel = ProductViewModel()
    val product by viewModel.productList.collectAsState()
    val colorOffWhite = Color(0xFF9C8F80)
    val colorGrey = Color.White
    var searchQuery by remember { mutableStateOf("") }
    fun onClick1(){
        navController.navigate("sample")
    }
    val gradientGreenRed = Brush.verticalGradient(0f to colorGrey, 1000f to colorOffWhite)
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.background(gradientGreenRed)

    ) {

        Column() {
//            TextField(
//                value = searchQuery,
//                onValueChange = { searchQuery = it },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(Color.White)
//                    .border(
//                        border = BorderStroke(1.dp, Color.LightGray),
//                        shape = RoundedCornerShape(5.dp)
//                    )
//                    .clickable { Log.d("Tag1", "ProductGrid: working ") }
//
//
//            )
//            Button(
//                onClick = { Log.d("Tag1", "ProductGrid: ") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(Color.White),
//            ) {
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    enabled = false,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color.White
                        )
                        .clickable { onClick1() }
                )
            }


        LazyVerticalGrid(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
            columns = GridCells.Fixed(2),

            ) {
            items(product.size) {

                ProductItem(product = product[it], onItemClick = ({
                    val s=it-1
                    val productId = product[s]?.id
                   val title = product[s]?.title
                    val price= product[s]?.price
                    val description= product[s]?.description
                    val category= product[s]?.category
                    val image= product[s]?.image
                    //val rating= product[it]?.rating?.rate
                    val route = "ProductDetailScreen?productId=$productId&title=$title&price=$price&description=$description&category=$category&image=$image"
                    navController.navigate(route)

                }))
            }
        }
    }
}
