package edu.um.coffe.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Cafe")
data class Cafe (
    @PrimaryKey
    val idCafe : String,
    val nome : String,
    val rating : Float,
    @Embedded
    val localizacao: Localizacao,
    @Embedded val contacto: Contacto,
    val fotos : String
    )
{
    @Transient
    var visibilidade : Boolean = false
}

data class Localizacao (
    val endereco: String,
    val latitude : Double,
    val longitude : Double
        )