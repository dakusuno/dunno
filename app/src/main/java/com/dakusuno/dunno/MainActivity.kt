package com.dakusuno.dunno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.post_list)
        postAdapter = PostAdapter()
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter = postAdapter

        val apiInterFace = ApiInterFace.create().getPost()

        apiInterFace.enqueue(object: Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if(response.body() !=null)
                    postAdapter.setPost(response.body()!!)
            }

        })


    }
}
