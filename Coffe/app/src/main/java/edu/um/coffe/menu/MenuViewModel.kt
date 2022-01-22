package edu.um.coffe.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.um.coffe.MainApplication
import edu.um.coffe.data.Cafe
import edu.um.coffe.data.Contacto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MenuViewModel : ViewModel() {
    private val model = MainApplication.repository
    var cafes : MutableList<Cafe> = mutableListOf<Cafe>()


    fun getCafes() {
        runBlocking {
            //cafes = model.getCafes();
            //println(cafes)
            cafes = mutableListOf(
                Cafe("1234","Garrafeira",5F,"Rua das finanças",
                    Contacto( "253222543","garrafeira@cafe.com"),"naoseicomo"),
                Cafe("1235","Tropical",4F,"Rua das Capela",
                    Contacto("253222544","tropical@cafe.com"),"naoseicomo")
            )
        }
    }
}