package com.nust.tcmconstitutionnursing.dataBase

import androidx.room.*
import com.nust.tcmconstitutionnursing.dataBase.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User):Long

    @Update
    fun updateUser(newUser: User)

    @Query("select * from User where accName == :accName")
    fun loadUser(accName :String): User

    @Delete
    fun deleteUser(user: User)
}