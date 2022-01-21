package edu.um.coffe.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class, Cafe::class,Favoritos::class,Historico::class,Horario::class], version = 3, exportSchema = false)
abstract class CoffeeDatabase : RoomDatabase() {
    abstract val coffeDao : AppDao

    companion object{
        private var INSTANCE: CoffeeDatabase? = null;

        fun getInstance(context : Context): CoffeeDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    CoffeeDatabase::class.java,
                    "coffee_db"
                ).fallbackToDestructiveMigration().allowMainThreadQueries()
                .build().also {
                    INSTANCE = it;
                }
            }
        }
    }
}