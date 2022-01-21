package edu.um.coffe.menu

import androidx.lifecycle.ViewModel
import edu.um.coffe.MainApplication
import edu.um.coffe.data.Cafe
import kotlinx.coroutines.runBlocking

class UserProfileViewModel : ViewModel() {
    private val model = MainApplication.repository

}