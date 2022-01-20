package edu.um.coffe.data

import androidx.room.Entity

@Entity(primaryKeys = ["idCafe","username"])
data class Historico(
    val idCafe: String,
    val username: String
)
