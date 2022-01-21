package edu.um.coffe.model

import java.time.LocalDateTime

class User (_userName: String, _email: String, _profilePicture: String, _favoritos: MutableList<CafeListEntry>, _historico: MutableList<CafeListEntry>){
    private var userName: String
    private var email: String
    private var profilePicture: String
    private var favoritos: MutableList<CafeListEntry>
    private var historico: MutableList<CafeListEntry>

    constructor(): this("", "", "", mutableListOf(), mutableListOf())

    constructor(_userName: String, _email: String, _profilePicture: String): this(_userName, _email, _profilePicture, mutableListOf(), mutableListOf())

    init {
        userName = _userName
        email = _email
        profilePicture = _profilePicture
        favoritos = _favoritos
        historico = _historico
    }

    fun getUserName(): String{
        return this.userName
    }

    fun getEmail(): String{
        return this.email
    }

    fun getProfilePicture(): String{
        return this.profilePicture
    }

    fun getFavoritos(): MutableList<CafeListEntry>{
        return this.favoritos
    }

    fun getHistorico(): MutableList<CafeListEntry>{
        return this.historico
    }

    fun setUserName(newUserName: String){
        this.userName = newUserName
    }

    fun setProfilePicture(newProfilePicture: String){
        this.profilePicture = newProfilePicture
    }

    fun addToFavoritos(cafeId: String){
        val entry: CafeListEntry = CafeListEntry(cafeId, LocalDateTime.now())
        favoritos.add(entry)
    }

    fun addToHistorico(cafeId: String){
        val entry: CafeListEntry = CafeListEntry(cafeId, LocalDateTime.now())
        historico.add(entry)
    }
}