package com.sandhyagill.whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.contains
import androidx.recyclerview.widget.RecyclerView

class RecyclerCommunityAdapter(var communityList: List<Community>): RecyclerView.Adapter<RecyclerCommunityAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var userImage = view.findViewById<ImageView>(R.id.ivImage)
        var personName = view.findViewById<TextView>(R.id.personName)
        var chatMsg = view.findViewById<TextView>(R.id.chatMsg)
        var time = view.findViewById<TextView>(R.id.time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_community,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return communityList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userImage.setImageResource(communityList[position].userImage)
        holder.personName.text = communityList[position].personName
        holder.chatMsg.text = communityList[position].chatMsg
        holder.time.text = communityList[position].time
    }
}