package com.nust.tcmconstitutionnursing.boot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nust.tcmconstitutionnursing.R
import kotlinx.android.synthetic.main.activity_software_license.*

class SoftwareLicenseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_software_license)
        agree.setOnClickListener {
            //同意软件服务协议，返回登录页面
            finish()
        }
    }
}