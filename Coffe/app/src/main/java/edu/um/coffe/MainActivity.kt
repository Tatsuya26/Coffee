package edu.um.coffe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.um.coffe.data.CoffeeDatabase
import edu.um.coffe.login.LoginFragment
import edu.um.coffe.model.Model

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow()
        }
    }


    }
