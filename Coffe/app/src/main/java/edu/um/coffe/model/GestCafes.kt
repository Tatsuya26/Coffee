package edu.um.coffe.model

import edu.um.coffe.data.*
import edu.um.coffe.data.Cafe
import edu.um.coffe.data.User
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.time.LocalDateTime

class GestCafes (private val appDao: DataBaseAcess) {

    var user : User? = null
    private var cafes: List<Cafe> = appDao.getCafes();
    lateinit var favUser : MutableList<Cafe>
    lateinit var histUser : MutableList<Cafe>


    suspend fun insertCafe(cafe : Cafe) {
        appDao.addCafe(cafe)
    }

    suspend fun insertUser(user : User) {
        appDao.addUser(user)
    }

    suspend fun autenticarUtilizador(username: String,password: String) : Boolean {
        val u: User? = appDao.getUser(username)
        if (u == null || u.password.compareTo(password) != 0) {
            return false
        }
        user = u
        favUser = getFavoritos()
        histUser = getHistorico()
        return true
    }

    suspend fun addToFavoritos(idCafe: String): Boolean{
        return if(idCafeExiste(idCafe) && user != null) {
            var fav : Favoritos = Favoritos(idCafe,user!!.username, LocalDateTime.now())
            appDao.addFavoriteCafe(fav)
            true
        } else
            false
    }

    private fun idCafeExiste(idCafe: String): Boolean{
        var res = false
        for(cafe in this.cafes) {
            if (cafe.idCafe == idCafe) {
                res = true
                break
            }
        }
        return res
    }

    fun getCafes(): List<Cafe> {
        return appDao.getCafes()
    }

    suspend fun addToHistorico(idCafe: String) {
        if(idCafeExiste(idCafe) && user != null) {
            var hist : Historico = Historico(idCafe,user!!.username, LocalDateTime.now())
            appDao.addHistoricoCafe(hist)
        }
    }

    suspend fun getFavoritos() : MutableList<Cafe> {
        if (user == null) return mutableListOf()
        var favs : List<Favoritos> = appDao.getFavoriteCafesFromUser(user!!.username)
        var cafesFav = mutableListOf<Cafe>()
        for (fav in favs) {
            var c :Cafe = appDao.getCafe(fav.idCafe)
            cafesFav.add(c)
        }
        return cafesFav
    }

    suspend fun getHistorico() : MutableList<Cafe> {
        if (user == null) return mutableListOf()
        var hist : List<Historico> = appDao.getHistoricoFromUser(user!!.username).sortedByDescending { it.dataAdicionado }
        var cafesFav = mutableListOf<Cafe>()
        for (fav in hist) {
            var c :Cafe = appDao.getCafe(fav.idCafe)
            cafesFav.add(c)
        }
        return cafesFav
    }

    suspend fun removeFavorito(idCafe: String) {
        val listaFavs = appDao.getFavoriteCafesFromUser(user!!.username)
        for (i in listaFavs.indices) {
            if (listaFavs[i].idCafe.compareTo(idCafe) == 0) appDao.removeFavorito(listaFavs[i])
        }
    }

    fun logout() {
        user = null
    }

    suspend fun atualizaPassword(newPassword: String) {
        if (user != null) {
            val u = user
            u!!.password = newPassword
            appDao.updateUser(u)
        }
    }

    suspend fun atualizaFotoPerfil(novaFoto: Bitmap) {
        if(user != null) {
            var u = user
            u!!.foto = novaFoto
            appDao.updateUser(u)
        }
    }

    fun getFotoPerfil(): Bitmap? {
        if (user != null) {
            return user!!.foto
        }
        else return null
    }
}