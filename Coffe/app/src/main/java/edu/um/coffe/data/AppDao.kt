package edu.um.coffe.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AppDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCafe(cafe : Cafe)

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHorario(horario : Horario)

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user : User)

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavoriteCafe(fav : Favoritos)

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHistoricoCafe(hist: Historico)

    @Query("Select * from User where username = :username")
    suspend fun getUser(username: String) : User

    @Query("Select * from User")
    suspend fun getUsers() : List<User>

    @Query("Select * from Cafe")
    suspend fun getCafes() : List<Cafe>

    @Transaction
    @Query("Select * from Favoritos where username = :username")
    suspend fun getFavoriteCafesFromUser(username : String) : List<Favoritos>

    @Transaction
    @Query("Select * from Historico where username = :username")
    suspend fun getHistoricoFromUser(username: String) : List<Historico>

}