package edu.um.coffe.model

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import edu.um.coffe.data.*
import edu.um.coffe.data.Cafe
import edu.um.coffe.data.User
import kotlinx.coroutines.launch

class Model (private val appDao: AppDao) {

    var user : User? = null
    private var cafes: List<Cafe> = appDao.getCafes();


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
        return true
    }

    suspend fun addToFavoritos(idCafe: String): Boolean{
        if(idCafeExiste(idCafe)) {
            var fav : Favoritos = Favoritos(idCafe,user!!.username)
            appDao.addFavoriteCafe(fav)
            return true
        }
        else
            return false
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
}