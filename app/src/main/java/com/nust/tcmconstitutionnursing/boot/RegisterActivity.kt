package com.nust.tcmconstitutionnursing.boot


import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import cn.smssdk.EventHandler
import cn.smssdk.SMSSDK
import com.mob.MobSDK
import com.nust.tcmconstitutionnursing.R
import com.nust.tcmconstitutionnursing.dataBase.User
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {
    lateinit var  viewModel : RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        //进入软件协议详情页
        SoftwareLicense.setOnClickListener {
            val intent = Intent(this, SoftwareLicense::class.java)
            startActivity(intent)
        }
        //获取短信验证码
//        MobSDK.submitPolicyGrantResult(true, null)
//        val eh: EventHandler = object : EventHandler() {
//            override fun afterEvent(event: Int, result: Int, data: Any?) {
//                // TODO 此处不可直接处理UI线程，处理后续操作需传到主线程中操作
//                val msg = Message()
//                msg.arg1 = event
//                msg.arg2 = result
//                msg.obj = data
////                mHandler.sendMessage(msg)
//            }
//        }
//        //注册一个事件回调监听，用于处理SMSSDK接口请求的结果
//        SMSSDK.registerEventHandler(eh)
//        get_verification_code.setOnClickListener {
//           var phone =  phoneNumber.text.toString()
//            if (phone.length < 13){
//                Toast.makeText(this,"输入手机号码有误，请重新输入",Toast.LENGTH_SHORT).show()
//            }else{
//                SMSSDK.getVerificationCode("86", phone);
//            }
//        }
        register.setOnClickListener {
            var user : User? =  isValidAccount()
            if (user!=null){
                //是一个有效账号，进行注册确认，有两种结果，注册成功跳转至登录界面，注册失败，提示用户
                viewModel.registerUser(user)
            }
        }
        cancel.setOnClickListener {
            finish()
        }
    }
    private fun isValidAccount() : User?{
        //账号不能为空
        var newAccount = account.text.toString()
        if(newAccount == ""){
            Toast.makeText(this,"账号不能为空",Toast.LENGTH_SHORT).show()
            return null
        }
        //两次密码要一致
        var passWord1 = password.text.toString()
        if (passWord1 == ""){
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show()
            return null
        }
        var passWord2 = confirmPassword.text.toString()
        if(passWord1 != passWord2){
            Toast.makeText(this,"密码不一致",Toast.LENGTH_SHORT).show()
            return null
        }
        if(!agreeLicense.isChecked){
            Toast.makeText(this,"请先同意软件协议",Toast.LENGTH_SHORT).show()
            return null
        }
        return User(
            account.text.toString(),
            password.text.toString(),
            phoneNumber.text.toString()
        )
    }
}