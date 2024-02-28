package com.sandhyagill.whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
 class RecyclerStatusAdapter(var statusList: List<Status>) : RecyclerView.Adapter<RecyclerStatusAdapter.ViewHolder>() {
    class ViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var personName = view.findViewById<TextView>(R.id.personName)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_status,parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.text = statusList[position].personName
    }

    override fun getItemCount(): Int {
        return statusList.size
    }
}