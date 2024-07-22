package com.nim057.kantinitdel.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.nim057.kantinitdel.MainActivity
import com.nim057.kantinitdel.R
import com.nim057.kantinitdel.app.ApiConfig
import com.nim057.kantinitdel.database.SharedPreferences
import com.nim057.kantinitdel.model.ResponseMenu
import kotlinx.android.synthetic.main.activity_registrasi.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrasiActivity : AppCompatActivity() {

    private lateinit var btnRegistrasi: Button
    private lateinit var edit_nama: EditText
    private lateinit var edit_email: EditText
    private lateinit var edit_notelp: EditText
    private lateinit var edit_password: EditText
    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)

        sp = SharedPreferences(this)

        btnRegistrasi = findViewById(R.id.btnRegisterRegistrasi)
        edit_nama = findViewById(R.id.edit_nama)
        edit_email = findViewById(R.id.edit_email)
        edit_notelp = findViewById(R.id.edit_notelp)
        edit_password = findViewById(R.id.edit_password)

        btnRegistrasi.setOnClickListener {
            registrasi()
        }

        btnGoogle.setOnClickListener{
            dataDummy()
        }
    }

    fun dataDummy(){
        edit_nama.setText("yosafattambun")
        edit_email.setText("yosafathtambun@gmail.com.com")
        edit_notelp.setText("085359568662")
        edit_password.setText("yos4f4t")
    }

    fun registrasi() {
        if (edit_nama.text.isEmpty()) {
            edit_nama.error = "Kolom nama tidak boleh kosong"
            edit_nama.requestFocus()
            return
        } else if (edit_email.text.isEmpty()) {
            edit_email.error = "Kolom email tidak boleh kosong"
            edit_email.requestFocus()
            return
        } else if (edit_notelp.text.isEmpty()) {
            edit_notelp.error = "Kolom nomor telepon tidak boleh kosong"
            edit_notelp.requestFocus()
            return
        } else if (edit_password.text.isEmpty()) {
            edit_password.error = "Kolom password tidak boleh kosong"
            edit_password.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.registrasi(edit_nama.text.toString(), edit_email.text.toString(), edit_password.text.toString()).enqueue(object : Callback<ResponseMenu>{
            override fun onResponse(call: Call<ResponseMenu>, response: Response<ResponseMenu>) {

                val respons = response.body()!!
                if (respons.success == 1){
                    sp.setStatusLogin(true)
                    val intent = Intent(this@RegistrasiActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this@RegistrasiActivity, "Success: "+respons.message, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@RegistrasiActivity, "Error: "+respons.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseMenu>, t: Throwable) {
                Toast.makeText(this@RegistrasiActivity, "Error: "+t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}