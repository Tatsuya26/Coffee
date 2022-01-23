package edu.um.coffe.menu

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.um.coffe.MainApplication
import edu.um.coffe.data.Cafe
import edu.um.coffe.data.User
import edu.um.coffe.model.Model
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MenuViewModel : ViewModel() {
    private val model = MainApplication.repository
    var cafes : List<Cafe> = mutableListOf()
    var favUser : MutableList<Cafe> = mutableListOf()
    var histUser : MutableList<Cafe> = mutableListOf()
    var user : User? = model.user

    fun adicionarFavorito(cafeid: String) {
        viewModelScope.launch {
            model.addToFavoritos(cafeid)
        }
    }
    fun getCafes() {
        runBlocking {
            cafes = model.getCafes().sortedByDescending { it.rating }
        }
    }

    fun adicionarHistorico(cafeid: String) {
        viewModelScope.launch {
            model.addToHistorico(cafeid)
        }
    }

    fun getFavourites() {
         runBlocking {
            favUser = model.getFavoritos()
        }
    }

    fun getHistorico() {
        runBlocking {
            histUser = model.getHistorico()
        }
    }

    fun removerFavorito(idCafe: String) {
        viewModelScope.launch {
            model.removeFavorito(idCafe)
        }
    }

    fun getUsername(): String {
        return if (user == null) {
            "USER"
        } else user!!.username
    }

    fun logout() {
        model.logout()
        user = null
    }

    fun getUserPassword(): String = user!!.password
    fun atualizaPassword(newPassword: String) {
        viewModelScope.launch {
            model.atualizaPassword(newPassword)
        }
    }

    fun mudarFotoPerfil(novaFoto: Bitmap) {
        viewModelScope.launch {
            model.atualizaFotoPerfil(novaFoto)
        }
    }

    fun getImage(): Bitmap? {
        return runBlocking {
            return@runBlocking model.getFotoPerfil()
        }
    }

}