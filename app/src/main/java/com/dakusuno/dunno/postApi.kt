package com.dakusuno.dunno

import retrofit2.Call
import retrofit2.http.GET


interface RecyclerInterface {
    @GET("/lists")
    fun getPost() : Call<List<Post>>
}