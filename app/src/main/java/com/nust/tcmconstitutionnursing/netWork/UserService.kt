package com.nust.tcmconstitutionnursing.netWork

import com.nust.tcmconstitutionnursing.dataBase.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {
    @POST("register")
    fun register(@Body user:User):Call<Boolean>

    @GET("logIn")
    fun logIn():Call<User>

}