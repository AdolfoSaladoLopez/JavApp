package com.adolfosalado.javapp.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.adolfosalado.javapp.models.User
import com.adolfosalado.javapp.models.relations.UserWithTools

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM User")
    suspend fun getUser(): User

    @Transaction
    @Query("SELECT * FROM User")
    suspend fun getUserWithTools(): List<UserWithTools>


}