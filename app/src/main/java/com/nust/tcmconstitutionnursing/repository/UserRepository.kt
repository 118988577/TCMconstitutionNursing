package com.nust.tcmconstitutionnursing.repository


import android.content.Intent
import android.text.style.AlignmentSpan
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.liveData
import com.nust.tcmconstitutionnursing.boot.LogInActivity
import com.nust.tcmconstitutionnursing.boot.MyApplication
import com.nust.tcmconstitutionnursing.dataBase.AppDatabase
import com.nust.tcmconstitutionnursing.dataBase.User
import com.nust.tcmconstitutionnursing.netWork.ServiceCreator
import com.nust.tcmconstitutionnursing.netWork.UserService
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

object UserRepository {
    private val userDao = AppDatabase.getDatabase(MyApplication.context).userDao()
    fun registerUser(user: User) = liveData<User>(Dispatchers.IO){
        //1.向服务器提交注册事件
        val registerService = ServiceCreator.create(UserService::class.java)
        registerService.register(user).enqueue(object : Callback<Boolean> {
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
            }
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                val result = response.body()
                val isvalid = result?:false
                if (isvalid){
                    Toast.makeText(MyApplication.context,"注册成功", Toast.LENGTH_SHORT).show()
                    //注册成功，在本地数据库存储账户信息
                    userDao.insertUser(user)

                }else{
                    Toast.makeText(MyApplication.context,"注册失败，请稍后再试", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
    fun logInUser(accName:String,accPwd:String):Boolean{
         var user = User("", "", "")
        thread {
            user  = userDao.loadUser(accName)
        }
        return user.accName != ""&&user.accPwd == accPwd
    }
    fun detectUser(accName: String):Boolean{
        var user = User("", "", "")
        thread {
            user  = userDao.loadUser(accName)
        }
        return user.accName != ""
    }
    fun deleteUser(){

    }
}