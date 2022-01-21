package com.androiddevs.shoppinglisttestingyt.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.shoppinglisttestingyt.R
import com.androiddevs.shoppinglisttestingyt.ui.viewmodel.ShoppingViewModel

class ImagePickFragment: Fragment(R.layout.fragment_image_pick){
    lateinit var vieModel: ShoppingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vieModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)
    }
}