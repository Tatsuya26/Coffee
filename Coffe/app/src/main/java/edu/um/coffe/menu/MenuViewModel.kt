package edu.um.coffe.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.um.coffe.MainApplication
import edu.um.coffe.data.Cafe
import edu.um.coffe.data.Contacto
import edu.um.coffe.data.Localizacao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MenuViewModel : ViewModel() {
    private val model = MainApplication.repository
    var cafes : List<Cafe> = mutableListOf<Cafe>()
    lateinit var favUser : MutableList<Cafe>
    lateinit var histUser : MutableList<Cafe>



    fun adicionarFavorito(cafeid: String) {
        viewModelScope.launch {
            model.addToFavoritos(cafeid)
        }
    }
    fun getCafes() {
        runBlocking {
            cafes = model.getCafes();
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
}