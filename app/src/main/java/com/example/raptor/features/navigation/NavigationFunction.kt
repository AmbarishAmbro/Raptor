package com.example.raptor.features.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.raptor.features.presentation.component.ProductGrid
import com.example.raptor.features.presentation.component.TestRun.ProductGridSample
import com.example.raptor.features.presentation.screen.ProductDetailScreen
import com.example.raptor.features.presentation.screen.SearchScreen


@Composable
fun NavigationFunction(){
    val navController = rememberNavController()
    val navigationHost = NavHost(navController = navController, startDestination ="ProductScreen" ) {
        composable("ProductScreen"){
            ProductGrid(navController)
        }
        composable(
            "ProductDetailScreen?productId={productId}&title={title}&price={price}&description={description}&category={category}&image={image}",
            arguments = listOf(
                navArgument("productId") { type = NavType.IntType },
                navArgument("title") { type = NavType.StringType },
                navArgument("price") { type = NavType.FloatType },
                navArgument("description") { type = NavType.StringType },
                navArgument("category") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            val title = backStackEntry.arguments?.getString("title") ?: "Title"
            val price = backStackEntry.arguments?.getDouble("price") ?: 0.0
            val description = backStackEntry.arguments?.getString("description") ?: ""
            val category = backStackEntry.arguments?.getString("category") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ProductDetailScreen(
                productId = productId,
                title = title,
                price = price,
                description = description,
                category = category,
                image = image,
                onBackPress = {
                    navController.popBackStack()
                }
            )
        }
        composable("sample"){
            SearchScreen(navController)
        }
    }

}