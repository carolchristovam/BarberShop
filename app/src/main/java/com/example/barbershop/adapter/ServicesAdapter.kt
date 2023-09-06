package com.example.barbershop.adapter

import android.content.Context
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
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ServicesViewHolder(binding: ServicesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imgService = binding.imgService
        val txtService = binding.

    }

}