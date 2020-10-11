package com.nust.tcmconstitutionnursing

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nust.tcmconstitutionnursing.boot.LogInActivity
import com.nust.tcmconstitutionnursing.boot.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //进行已登录判断
        var editor = getSharedPreferences("LoginDetect",Context.MODE_PRIVATE)
        if (editor.getBoolean("isvalid",false)){
            //直接跳转至主界面
        }
        register.setOnClickListener {
            //进入注册页
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        logIn.setOnClickListener {
            //进入登录页
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }
    }
}