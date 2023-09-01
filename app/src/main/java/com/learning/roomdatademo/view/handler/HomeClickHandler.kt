package com.learning.roomdatademo.view.handler

import android.content.Context
import androidx.navigation.fragment.findNavController
import com.learning.roomdatademo.R
import com.learning.roomdatademo.view.HomeFragment

class HomeClickHandler(private val context: HomeFragment) {

    fun navigateAddUser() {
        context.let {
            context.apply {
                findNavController().navigate(R.id.action_homeFragment_to_addUserFragment)
            }
        }
    }
    fun deleterAllCLick(){
        context.let {
            context.apply {
                deleteAll()
            }
        }
    }
}