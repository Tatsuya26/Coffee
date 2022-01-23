package edu.um.coffe.register

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.um.coffe.MainApplication
import edu.um.coffe.data.User
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class UserRegisterViewModel : ViewModel() {
    private val model = MainApplication.repository
    private var usernameText = ""
    private var passwordText = ""
    private var emailText = ""
    var logado : Boolean = false

    fun updateUsername(username: String) {
        usernameText = username
    }

    fun updatePassword(password: String) {
        passwordText = password
    }

    fun updateEmail(email : String) {
        emailText = email
    }

    fun registarUtilizador(bitmap: Bitmap) {
        runBlocking {
            val u = User(usernameText, passwordText, emailText,bitmap)
            if (usernameText != "" && passwordText != "" && emailText !="")
                model.insertUser(u)
        }
    }

    fun autenticarUtilizador() : Boolean{
        return runBlocking {
            val b = model.autenticarUtilizador(usernameText, passwordText)
            usernameText = ""
            passwordText = ""
            if (b) logado = true
            return@runBlocking logado
        }
    }

}