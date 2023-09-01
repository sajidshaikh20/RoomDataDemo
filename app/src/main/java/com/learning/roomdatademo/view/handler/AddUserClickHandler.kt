package com.learning.roomdatademo.view.handler

import android.content.Context
import com.learning.roomdatademo.view.AddUserFragment

class AddUserClickHandler(private val context: AddUserFragment) {

    fun addUserClick() {
        context.let {
            context.apply {
                instetDataToDatabase()
            }
        }
    }


}