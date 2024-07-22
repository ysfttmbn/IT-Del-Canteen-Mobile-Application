package com.nim057.kantinitdel.database

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(activity: Activity){
    val mypref = "MAIN_PRF"
    val sp:SharedPreferences
    val statusLogin = "Login"
    val name = "name"
    val no_telp = "no_telp"
    val email = "email"

    init {
        sp = activity.getSharedPreferences(mypref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status:Boolean){
        sp.edit().putBoolean(statusLogin, status).apply()
    }

    fun getStatusLogin():Boolean{
        return sp.getBoolean(statusLogin, false)
    }

    fun setString(key:String,value:String){
        sp.edit().putString(key, value).apply()
    }
}