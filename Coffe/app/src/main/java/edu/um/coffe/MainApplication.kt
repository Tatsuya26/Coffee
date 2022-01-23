package edu.um.coffe

import android.app.Application
import edu.um.coffe.data.*
import edu.um.coffe.model.Model
import kotlinx.coroutines.runBlocking

class MainApplication :Application() {
    val database by lazy { CoffeeDatabase.getInstance(this) }

    companion object {
        lateinit var repository : Model
    }

    override fun onCreate() {
        super.onCreate()
        repository =  Model(database.coffeDao)
        runBlocking {
            repository.insertCafe(Cafe(
                        "1236", "Garrafa", 5F, Localizacao("Rua das finanças",  41.65433066576365, -8.43504224690325),
                        Contacto("253222543", "garrafeira@cafe.com"), Horario(9,0,18,0),"dsaidsja")
                    )
            repository.insertCafe(
                Cafe("1237","Selva",2.4F,Localizacao("Rua das finanças",  41.65433066576365, -8.43504224690325),
                    Contacto("253222544","tropical@cafe.com"), Horario(10,0,22,30),"naoseicomo"))
        }
    }
}