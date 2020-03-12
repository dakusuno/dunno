package com.dakusuno.dunno

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter:RecyclerView.Adapter<PostAdapter.ViewHolder>(){
    var lpost: List<Post> = listOf()
    class ViewHolder (view:View): RecyclerView.ViewHolder(view) {
        val anime:TextView = view.findViewById(R.id.anime)
        val character:TextView = view.findViewById(R.id.character)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_post,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lpost.size
    }
    fun setPost(lpost:List<Post>){
        this.lpost = lpost
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.anime.text = lpost.get(position).title
        holder.character.text = lpost.get(position).body
    }

}

