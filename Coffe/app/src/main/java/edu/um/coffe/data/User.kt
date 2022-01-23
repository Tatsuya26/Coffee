package edu.um.coffe.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey
    val username: String,
    var password: String,
    val email: String
)
