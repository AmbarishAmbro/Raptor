package com.example.raptor.features.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.raptor.core.remote.RetrofitInstance
import com.example.raptor.features.data.model.ProductData
import com.example.raptor.features.data.model.ProductList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    val TAG = "Ambarish "
    private val _productList = MutableStateFlow<List<ProductData?>>(emptyList<ProductData>())
    val productList: StateFlow<List<ProductData?>> = _productList
    private val apiService = RetrofitInstance.api
    private val _searchText =MutableStateFlow("")
    val searchText= _searchText.asStateFlow()
    private val _isSearching=MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    init {

        viewModelScope.launch {
            val productList = apiService.fetchProductList("https://fakestoreapi.com/products")
           _productList.value = productList


        }
    }

    fun onSearchChangeText(text:String){
        _searchText.value = text

    }
}