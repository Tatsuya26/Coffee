package edu.um.coffe

import android.app.Application
import android.content.Context
import edu.um.coffe.data.Cafe
import edu.um.coffe.data.CoffeeDatabase
import edu.um.coffe.data.Contacto
import edu.um.coffe.data.Localizacao
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
                        "1234", "Garrafeira", 5F, Localizacao("Rua das finanças",  41.65433066576365, -8.43504224690325),
                        Contacto("253222543", "garrafeira@cafe.com"), "naoseicomo"
                    )
                    )
        }
    }
}