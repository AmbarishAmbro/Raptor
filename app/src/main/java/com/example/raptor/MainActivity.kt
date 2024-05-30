package com.example.raptor

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.raptor.features.data.model.ProductData
import com.example.raptor.features.navigation.NavigationFunction
import com.example.raptor.features.presentation.component.ProductGrid
import com.example.raptor.features.presentation.component.ProductItem
import com.example.raptor.features.presentation.viewModel.ProductViewModel
import com.example.raptor.ui.theme.RaptorTheme

class MainActivity : ComponentActivity() {
    private val viewModel = ProductViewModel()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaptorTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(topBar = { TopAppBar(title = { Text(text = "Raptor") },
                    colors = TopAppBarDefaults.topAppBarColors(
                    Color(0xFF9C8F80)
                )) }) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = it.calculateTopPadding()),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavigationFunction()
                    }
                }
            }
        }
    }
}


