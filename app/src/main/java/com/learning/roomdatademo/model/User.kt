package com.learning.roomdatademo.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "userTable")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int ,
    var firstName: String,
    var LastName: String,
    var age:String
):Parcelable
