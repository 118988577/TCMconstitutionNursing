package com.nust.tcmconstitutionnursing.boot

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nust.tcmconstitutionnursing.dataBase.User
import com.nust.tcmconstitutionnursing.netWork.ServiceCreator
import com.nust.tcmconstitutionnursing.netWork.UserService
import com.nust.tcmconstitutionnursing.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import kotlin.concurrent.thread

class RegisterViewModel:ViewModel() {
    fun registerUser(user: User){
        UserRepository.registerUser(user)
    }
}
