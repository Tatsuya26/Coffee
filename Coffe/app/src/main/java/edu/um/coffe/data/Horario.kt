package edu.um.coffe.data

import androidx.room.Entity

@Entity(primaryKeys = ["cafeID","diaSemana"])
data class Horario(
    val cafeID: String,
    val diaSemana: Int,
    val horaAbertura: Int,
    val horaFecho: Int
)
