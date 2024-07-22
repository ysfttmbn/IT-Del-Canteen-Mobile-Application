package com.nim057.kantinitdel.app

import com.nim057.kantinitdel.model.ResponseMenu
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("registrasi") // "http://127.0.0.1:8000/api/registrasi"
    fun registrasi(
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("password") password:String
    ):Call<ResponseMenu>

    @FormUrlEncoded
    @POST("login") // "http://127.0.0.1:8000/api/login"
    fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ):Call<ResponseMenu>
}