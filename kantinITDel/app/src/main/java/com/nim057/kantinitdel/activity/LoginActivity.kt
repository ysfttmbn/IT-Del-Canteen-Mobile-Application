package com.nim057.kantinitdel.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nim057.kantinitdel.MainActivity
import com.nim057.kantinitdel.R
import com.nim057.kantinitdel.app.ApiConfig
import com.nim057.kantinitdel.database.SharedPreferences
import com.nim057.kantinitdel.model.ResponseMenu
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sp = SharedPreferences(this)

        btnLoginLogin.setOnClickListener{
            login()
        }
    }

    fun login() {
        if (edit_emailLogin.text.isEmpty()) {
            edit_emailLogin.error = "Kolom email tidak boleh kosong"
            edit_emailLogin.requestFocus()
            return
        } else if (edit_passwordLogin.text.isEmpty()) {
            edit_passwordLogin.error = "Kolom password tidak boleh kosong"
            edit_passwordLogin.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.login(edit_emailLogin.text.toString(), edit_passwordLogin.text.toString()).enqueue(object :
            Callback<ResponseMenu> {
            override fun onResponse(call: Call<ResponseMenu>, response: Response<ResponseMenu>) {

                val respons = response.body()!!
                if (respons.success == 1){
                    sp.setStatusLogin(true)
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this@LoginActivity, "Success: "+respons.message, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@LoginActivity, "Error: "+respons.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseMenu>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error: "+t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}