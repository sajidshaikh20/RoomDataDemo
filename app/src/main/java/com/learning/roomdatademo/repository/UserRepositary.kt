package com.learning.roomdatademo.repository

import androidx.lifecycle.LiveData
import com.learning.roomdatademo.model.User
import com.learning.roomdatademo.room.UserDao

class UserRepositary(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readALlData()

    fun  addUser(user: User){
        userDao.addUser(user)
    }
    fun updateser(user: User){
        userDao.updateUser(user)
    }

    fun deleteAllUser(){
        userDao.deleterAll()
    }
    fun  deleteuser(user: User){
        userDao.deleteUser(user)
    }
}