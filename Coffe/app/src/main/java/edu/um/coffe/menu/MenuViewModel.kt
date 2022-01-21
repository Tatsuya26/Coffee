package edu.um.coffe.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.um.coffe.MainApplication
import edu.um.coffe.data.Cafe
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MenuViewModel : ViewModel() {
    private val model = MainApplication.repository
    private var searchString : String = ""
    var cafes : List<Cafe> = mutableListOf<Cafe>()


    fun getCafes() {
        runBlocking {
            cafes = model.getCafes();
            println(cafes)
        }
    }
}