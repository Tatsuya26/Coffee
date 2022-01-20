package edu.um.coffe.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.um.coffe.MainApplication
import edu.um.coffe.data.User
import kotlinx.coroutines.launch

class UserRegisterViewModel : ViewModel() {
    private val model = MainApplication.repository
    private var usernameText = ""
    private var passwordText = ""
    private var emailText = ""

    fun updateUsername(username: String) {
        usernameText = username
    }

    fun updatePassword(password: String) {
        passwordText = password
    }

    fun updateEmail(email : String) {
        emailText = email
    }

    fun registarUtilizador() {
        viewModelScope.launch {
            val u = User(usernameText, passwordText, emailText)
            model.insertUser(u)
        }
    }

}