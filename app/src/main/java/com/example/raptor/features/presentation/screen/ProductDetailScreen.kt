package com.example.raptor.features.presentation.screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

import com.example.raptor.R
import com.example.raptor.features.data.model.Rating


@Composable
fun ProductDetailScreen(
    productId:Int?,
    title: String?,
    price: Double?,
    description: String?,
    category: String?,
    image: String?,
    onBackPress: () -> Unit = {}
//    rating: Double?
) {
    val colorOffWhite = Color(0xFF9C8F80)
    val colorGrey = Color.White

    val gradientGreenRed = Brush.verticalGradient(0f to colorGrey, 1000f to colorOffWhite)

    Column(
        modifier = Modifier.background(gradientGreenRed)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        // Product Image
        AsyncImage(
            model = image,
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.LightGray)
                .border(
                    BorderStroke(.5.dp, Color.LightGray),
                    RoundedCornerShape(5.dp)
                ),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Product Details
        Text(text = title.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = description.toString(), fontSize = 16.sp, color = Color.Gray, maxLines = 3)
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "$112", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Red)
        Text(
            text = "$150",
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 4.dp)
                .background(Color.Gray.copy(alpha = 0.2f))
        )
        Text(text = "5 in stock", fontSize = 16.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))

        // Description
        Text(
            text = "Description",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "This is 100% cotton shirt which is made by Bangladesh dummy text.",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Color Selection
        Text(text = "Choose Colors", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Row {
            ColorOption(Color.LightGray)
            ColorOption(Color.Cyan)
            ColorOption(Color.Red)
            ColorOption(Color.Green)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { /* TODO: Add to cart */ }, modifier = Modifier.weight(1f)) {
                Text(text = "ADD TO CART")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { /* TODO: Buy now */ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
            ) {
                Text(text = "BUY NOW")
            }
        }
    }
}

@Composable
fun ColorOption(color: Color) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(color, shape = RoundedCornerShape(4.dp))
            .padding(8.dp)
    )
}
