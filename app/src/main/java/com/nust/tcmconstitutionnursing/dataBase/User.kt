package com.nust.tcmconstitutionnursing.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(var accName:String,var accPwd:String,var phoneNumber:String) {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}