package edu.um.coffe.data

import androidx.room.Embedded
import androidx.room.Relation

data class CafeWithHorarios(
    @Embedded val cafe:Cafe,
    @Relation(
        parentColumn = "idCafe",
        entityColumn = "cafeID"
    )
    val horarios: List<Horario>
)
