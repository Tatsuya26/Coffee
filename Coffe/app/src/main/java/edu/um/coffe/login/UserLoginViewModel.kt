package edu.um.coffe.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.um.coffe.MainApplication
import edu.um.coffe.data.User
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class UserLoginViewModel: ViewModel() {
    private val model = MainApplication.repository
    private var usernameText = ""
    private var passwordText = ""
    var logado : Boolean = false

    fun updateUsername(username: String) {
        usernameText = username
    }

    fun updatePassword(password: String) {
        passwordText = password
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