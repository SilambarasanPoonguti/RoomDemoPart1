package com.silambar.roomdemopart1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.silambar.roomdemopart1.db.FarmerEntity

class FarmerAdapter(private var farmers:List<FarmerEntity>):RecyclerView.Adapter<FarmerAdapter.FarmerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_farmer_item, parent, false)
        return FarmerHolder(view)
    }

    override fun getItemCount(): Int = farmers.size

    override fun onBindViewHolder(holder: FarmerHolder, position: Int) {
       val farmer = farmers[position]
        val text = "Name: ${farmer.farmerName}\nSon Of: ${farmer.sonOf}\nAge: ${farmer.age}\nFrom: ${farmer.place}"
        holder.farmerText?.text = text
    }

    inner class FarmerHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var farmerText = itemView?.findViewById<TextView>(R.id.farmer_text)
    }
}