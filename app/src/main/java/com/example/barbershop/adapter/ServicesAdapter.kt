package com.example.barbershop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.databinding.ActivityHomeBinding
import com.example.barbershop.databinding.ServicesItemBinding
import com.example.barbershop.model.Services

class ServicesAdapter(
    private val context: Context,
    private val servicesList: MutableList<Services>
) :
    RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val listItem = ServicesItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return ServicesViewHolder(listItem)
    }

    override fun getItemCount() = servicesList.size


    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.imgService.setImageResource(servicesList[position].img!!)
        holder.txtService.text=servicesList[position].name
    }

    inner class ServicesViewHolder(binding: ServicesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imgService = binding.imgService
        val txtService = binding.txtService

    }

}