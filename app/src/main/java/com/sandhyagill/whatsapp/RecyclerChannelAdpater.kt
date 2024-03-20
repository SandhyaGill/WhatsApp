package com.sandhyagill.whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerChannelAdpater( var channelList: List<Channels>) : RecyclerView.Adapter<RecyclerChannelAdpater.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var userImage = view.findViewById<ImageView>(R.id.ivImage)
        var personName = view.findViewById<TextView>(R.id.personName)
        var chatMsg = view.findViewById<TextView>(R.id.chatMsg)
        var time = view.findViewById<TextView>(R.id.time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_channels,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return channelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userImage.setImageResource(channelList[position].userImage)
        holder.personName.text = channelList[position].personName
        holder.chatMsg.text = channelList[position].chatMsg
        holder.time.text = channelList[position].time
    }
}