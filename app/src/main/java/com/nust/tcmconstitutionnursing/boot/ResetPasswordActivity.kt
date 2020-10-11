package com.nust.tcmconstitutionnursing.boot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nust.tcmconstitutionnursing.R
import com.nust.tcmconstitutionnursing.repository.UserRepository
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        confirmReset.setOnClickListener {
            val passpwd1 = password.text.toString()
            if (passpwd1.isEmpty()){
                Toast.makeText(this,"密码不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val passpwd2 = confirmPassword.text.toString()
            if (passpwd2.isEmpty()){
                Toast.makeText(this,"密码不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (passpwd1!=passpwd2){
                Toast.makeText(this,"两次密码不一致", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
//            UserRepository.deleteUser()
//            UserRepository.registerUser()
        }
    }
}