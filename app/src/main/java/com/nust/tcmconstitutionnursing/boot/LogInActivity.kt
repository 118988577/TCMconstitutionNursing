package com.nust.tcmconstitutionnursing.boot

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.nust.tcmconstitutionnursing.R
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {

    lateinit var  viewModel : LogInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        viewModel = ViewModelProviders.of(this).get(LogInViewModel::class.java)
        var editor =  getSharedPreferences("user",Context.MODE_PRIVATE).edit()
        var prefs = getSharedPreferences("user",Context.MODE_PRIVATE)
        if (rememberPassword.isChecked()){
            userName.setText(prefs.getString("accName","").toString());
            passWord.setText(prefs.getString("accPwd","").toString())
        }
        logIn.setOnClickListener {
            val account = userName.text.toString()
            if (account.isEmpty()){
                Toast.makeText(this,"账号不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val accPwd = passWord.text.toString()
            if (accPwd.isEmpty()){
                Toast.makeText(this,"密码不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //判断登录
            if(viewModel.logInUser(account,accPwd)){
                //登录成功
                if (rememberPassword.isChecked()){
                    editor.putString("accName",userName.text.toString())
                    editor.putString("accPwd",passWord.text.toString())
                    editor.apply()
                }
                //跳转至主界面
            }else{
                Toast.makeText(this,"登录失败", Toast.LENGTH_SHORT).show()
            }
        }
        register.setOnClickListener {
            //进入注册页面
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        forgetPassWord.setOnClickListener {
            //忘记密码，进入密码找回
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}