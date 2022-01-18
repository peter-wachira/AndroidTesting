package com.androiddevs.shoppinglisttestingyt.repositories

import androidx.lifecycle.LiveData
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingItem
import com.androiddevs.shoppinglisttestingyt.data.remote.responses.ImageResponse
import com.androiddevs.shoppinglisttestingyt.other.Resource

interface ShoppingRepository {
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)
    suspend fun deleteSHoppingItem(shoppingItem: ShoppingItem)
    fun observeShoppingItems(): LiveData<List<ShoppingItem>>
    fun observeTotalPrice():LiveData<Float>
    suspend fun searchForImage(imageQuery:String):Resource<ImageResponse>
}