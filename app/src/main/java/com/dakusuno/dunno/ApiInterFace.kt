package com.dakusuno.dunno

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterFace {
    @Headers("Content-Type : application/json")
    @GET("posts/")
    fun getPost(): Call<List<Post>>

    companion object{
        var BASEURL = "https://postdakusuno.herokuapp.com/lists"
        fun create():ApiInterFace{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterFace::class.java)
        }
    }
}