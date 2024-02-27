package com.sandhyagill.whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerCallAdapter(var callList: List<Call>) : RecyclerView.Adapter<RecyclerCallAdapter.ViewHolder>() {
    class ViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var personName = view.findViewById<TextView>(R.id.personName)
        var time = view.findViewById<TextView>(R.id.time)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_call,parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.text = callList[position].personName
        holder.time.text = callList[position].time
    }
    override fun getItemCount(): Int {
        return callList.size
    }
}