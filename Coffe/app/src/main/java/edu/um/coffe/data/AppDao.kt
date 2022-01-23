package edu.um.coffe.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AppDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCafe(cafe : Cafe)

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user : User)

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavoriteCafe(fav : Favoritos)

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHistoricoCafe(hist: Historico)

    @Update
    suspend fun updateUser(user : User)

    @Query("Select * from User where username = :username")
    suspend fun getUser(username: String) : User

    @Query("Select * from Cafe where idCafe =:idCafe")
    suspend fun getCafe(idCafe: String): Cafe

    @Query("Select * from User")
    suspend fun getUsers() : List<User>

    @Query("Select * from Cafe")
    fun getCafes() : List<Cafe>

    @Transaction
    @Query("Select * from Favoritos where username = :username")
    suspend fun getFavoriteCafesFromUser(username : String) : List<Favoritos>

    @Transaction
    @Query("Select * from Historico where username = :username")
    suspend fun getHistoricoFromUser(username: String) : List<Historico>

    @Delete
    suspend fun removeFavorito(fav: Favoritos)

}