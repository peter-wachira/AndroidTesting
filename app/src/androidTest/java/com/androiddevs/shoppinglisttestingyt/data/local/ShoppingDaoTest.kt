package com.androiddevs.shoppinglisttestingyt.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.androiddevs.shoppinglisttestingyt.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
@ExperimentalCoroutinesApi
class ShoppingDaoTest{

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var database: ShoppingItemDatabase
    private lateinit var shoppingDao : ShoppingDao

    @Before
    fun setUp(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShoppingItemDatabase::class.java
        ).allowMainThreadQueries().build()

        shoppingDao = database.shoppingDao()
    }
    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun insertShoppingItem() = runBlockingTest {
        val shoppingItem = ShoppingItem("name",12,1f,"url",2)
        shoppingDao.insertShoppingItem(shoppingItem)
      /*convert livedata item to list */
        val allShoppingItems = shoppingDao.observeAllShoppingItems().getOrAwaitValue()
        assertThat(allShoppingItems.contains(shoppingItem))
    }

    @Test
    fun deleteShoppingItems() = runBlockingTest {
        val shoppingItem = ShoppingItem("name",12,1f,"url",2)
        shoppingDao.insertShoppingItem(shoppingItem)
        shoppingDao.deleteShoppingItem(shoppingItem)
        val allShoppingItems = shoppingDao.observeAllShoppingItems().getOrAwaitValue()
        assertThat(allShoppingItems).doesNotContain(shoppingItem)
    }

    @Test
    fun observeTotalPriceSum() = runBlockingTest {
        val shoppingItem1 = ShoppingItem("name",2,10f,"url",1)
        val shoppingItem2 = ShoppingItem("name",4,5.5f,"url",2)
        val shoppingItem3 = ShoppingItem("name",0,100f,"url",3)
        shoppingDao.insertShoppingItem(shoppingItem1)
        shoppingDao.insertShoppingItem(shoppingItem2)
        shoppingDao.insertShoppingItem(shoppingItem3)

        val totalPriceSum = shoppingDao.observeTotalPrice().getOrAwaitValue()
        assertThat(totalPriceSum).isEqualTo(2 * 10f + 4 * 5.5f)


    }

}