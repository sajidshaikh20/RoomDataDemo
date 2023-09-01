package com.learning.roomdatademo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.learning.roomdatademo.model.User
import com.learning.roomdatademo.repository.UserRepositary
import com.learning.roomdatademo.room.UserDao
import com.learning.roomdatademo.room.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repositary: UserRepositary

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repositary = UserRepositary(userDao)
        readAllData = repositary.readAllData
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repositary.addUser(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {

            repositary.updateser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repositary.deleteuser(user)
        }
    }
    fun deleteAllUser() {
        viewModelScope.launch(Dispatchers.IO) {
            repositary.deleteAllUser()

        }
    }
}