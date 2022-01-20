package edu.um.coffe.data

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserFavourites(
    @Embedded val user: User,
    @Relation(
        parentColumn = "username",
        entityColumn = "idCafe",
        associateBy = Junction(Favoritos::class)
    )
    val cafes: List<Cafe>
)
