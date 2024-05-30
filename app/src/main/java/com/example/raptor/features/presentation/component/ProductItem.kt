package com.example.raptor.features.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.raptor.features.data.model.ProductData


@Composable
fun ProductItem(product: ProductData?, onItemClick: (id: Int) -> Unit) {
    val colorOffWhite = Color(0xFF9C8F80)
    val colorGrey = Color.White

    Card(
        modifier = Modifier
            .border(
                BorderStroke(.5.dp, Color.LightGray),
                RoundedCornerShape(5.dp)
            )
            .clip(RoundedCornerShape(5.dp))
            .background(Color.White)
            .wrapContentHeight()
            .padding(5.dp)
            .fillMaxWidth()
            .clickable { onItemClick(product?.id!!) }
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()

        ) {
            AsyncImage(
                modifier = Modifier
                    .size(150.dp)
                    .fillMaxWidth(),
                model = product?.image,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                filterQuality = FilterQuality.High,
            )

            Text(
                text = product?.title!!,
                style = MaterialTheme.typography.bodyMedium,
                softWrap = true,
                maxLines = 2,
                modifier = Modifier

                    .fillMaxWidth()
                    .wrapContentHeight(),
                color = Color.DarkGray
            )
            Text(
                modifier = Modifier.padding(bottom = 6.dp),
                text = "Price:${product?.price}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}