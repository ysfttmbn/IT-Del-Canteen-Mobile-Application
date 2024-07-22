package com.nim057.kantinitdel.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.nim057.kantinitdel.R
import com.nim057.kantinitdel.R.layout.activity_masuk
import com.nim057.kantinitdel.database.SharedPreferences

class MasukActivity : AppCompatActivity() {

    private lateinit var sp: SharedPreferences
    private lateinit var btnLogin:Button
    private lateinit var btnRegistrasi:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_masuk)

        sp = SharedPreferences(this)
        btnLogin = findViewById(R.id.btnLoginMasuk)
        btnRegistrasi = findViewById(R.id.btnRegistrasiMasuk)

        mainButton()

    }

    private fun mainButton(){
        btnLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnRegistrasi.setOnClickListener{
            startActivity(Intent(this, RegistrasiActivity::class.java))
        }
    }
}