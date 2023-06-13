package com.example.aadityaassignment_infraveo

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("userlist.php")
    fun getData(): Call<List<UsersItem>>
}