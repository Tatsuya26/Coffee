package edu.um.coffe.data

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey
    val username: String,
    var password: String,
    val email: String,
    val foto : Bitmap
)
