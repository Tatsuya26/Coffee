package edu.um.coffe

import android.app.Application
import edu.um.coffe.data.CoffeeDatabase
import edu.um.coffe.model.Model

class MainApplication :Application() {
    val database by lazy { CoffeeDatabase.getInstance(this) }

    companion object {
        lateinit var repository : Model
    }

    override fun onCreate() {
        super.onCreate()
        repository =  Model(database.coffeDao)
    }
}