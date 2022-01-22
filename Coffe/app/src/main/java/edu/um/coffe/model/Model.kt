package edu.um.coffe.model

import edu.um.coffe.data.*
import edu.um.coffe.data.Cafe
import edu.um.coffe.data.User

class Model (private val appDao: AppDao) {

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
            var fav : Favoritos = Favoritos(idCafe,user!!.username)
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
            var hist : Historico = Historico(idCafe,user!!.username)
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
        var hist : List<Historico> = appDao.getHistoricoFromUser(user!!.username)
        var cafesFav = mutableListOf<Cafe>()
        for (fav in hist) {
            var c :Cafe = appDao.getCafe(fav.idCafe)
            cafesFav.add(c)
        }
        return cafesFav
    }

    suspend fun removeFavorito(idCafe: String) {
        var fav = Favoritos(idCafe,user!!.username)
        appDao.removeFavorito(fav)
    }
}