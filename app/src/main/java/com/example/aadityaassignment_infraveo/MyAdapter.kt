package com.example.aadityaassignment_infraveo

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(var con: Context, var list : List<UsersItem>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(v : View): RecyclerView.ViewHolder(v)
    {
        var img= v.findViewById<ImageView>(R.id.ivContactPic)
        var name= v.findViewById<TextView>(R.id.tvContactName)
        var email= v.findViewById<TextView>(R.id.tvContactEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.contact_layout,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(con).load(list[position].profile).into(holder.img)
        holder.name.text=list[position].username
        holder.email.text=list[position].email

        holder.itemView.setOnClickListener {
            val intent= Intent(con,ChatPageActivity::class.java).addFlags(FLAG_ACTIVITY_NEW_TASK)
            val passName= list[position].username
            intent.putExtra("passName",passName)
            con.startActivity(intent)
        }

    }

}