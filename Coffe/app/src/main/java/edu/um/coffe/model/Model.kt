package edu.um.coffe.model

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import edu.um.coffe.data.AppDao
import edu.um.coffe.data.Cafe
import edu.um.coffe.data.CoffeeDatabase
import edu.um.coffe.data.User
import kotlinx.coroutines.launch

class Model (private val appDao: AppDao) {
    var user : User? = null

    suspend fun insertCafe(cafe : Cafe) {
        appDao.addCafe(cafe)
    }

    suspend fun insertUser(user : User) {
        appDao.addUser(user)
    }

    suspend fun autenticarUtilizador(username: String,password: String) : Boolean {
        val u: User = appDao.getUser(username)
        if (u == null || u.password.compareTo(password) != 0) {
            return false
        }
        user = u
        return true
    }
}