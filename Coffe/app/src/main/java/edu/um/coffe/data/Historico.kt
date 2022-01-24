package edu.um.coffe.data

import androidx.room.Entity
import java.time.LocalDateTime

@Entity(primaryKeys = ["idCafe","username"])
data class Historico(
    val idCafe: String,
    val username: String,
    val dataAdicionado : LocalDateTime
)
