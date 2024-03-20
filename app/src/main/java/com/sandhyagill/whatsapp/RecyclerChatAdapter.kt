package com.sandhyagill.whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerChatAdapter(var chatList: List<Chat>) : RecyclerView.Adapter<RecyclerChatAdapter.ViewHolder>() {
     class ViewHolder(var view: View): RecyclerView.ViewHolder(view){
         var userImage = view.findViewById<ImageView>(R.id.ivImage)
         var personName = view.findViewById<TextView>(R.id.personName)
         var chatMsg = view.findViewById<TextView>(R.id.chatMsg)
         var time = view.findViewById<TextView>(R.id.time)
     }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      var view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_chat,parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userImage.setImageResource(chatList[position].userImage)
        holder.personName.text = chatList[position].personName
        holder.chatMsg.text = chatList[position].chatMsg
        holder.time.text = chatList[position].time
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}