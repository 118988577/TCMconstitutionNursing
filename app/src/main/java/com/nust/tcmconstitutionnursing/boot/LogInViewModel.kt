package com.nust.tcmconstitutionnursing.boot

import androidx.lifecycle.ViewModel
import com.nust.tcmconstitutionnursing.repository.UserRepository

class LogInViewModel :ViewModel(){
    fun logInUser(accName:String,accPwd:String) : Boolean{
        return UserRepository.logInUser(accName,accPwd)
    }
}