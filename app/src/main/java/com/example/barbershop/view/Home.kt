package com.example.barbershop.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.barbershop.R
import com.example.barbershop.adapter.ServicesAdapter
import com.example.barbershop.databinding.ActivityHomeBinding
import com.example.barbershop.databinding.ActivityMainBinding
import com.example.barbershop.model.Services
import com.google.android.material.snackbar.Snackbar

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicesAdapter: ServicesAdapter
    private val servicesList: MutableList<Services> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val name = intent.extras?.getString("name")

        binding.txUserName.text = "Welcome, $name"
        val recyclerViewServices=binding.recyclerVieServices
        recyclerViewServices.layoutManager = GridLayoutManager(this,2)
        servicesAdapter= ServicesAdapter(this,servicesList)
        recyclerViewServices.setHasFixedSize(true)
        recyclerViewServices.adapter=servicesAdapter
        getServices()

    }

    private fun getServices(){
        val service1 = Services(R.drawable.img1,"Haircut")
        servicesList.add(service1)

        val service2 = Services(R.drawable.img2,"Beard cut")
        servicesList.add(service2)

        val service3 = Services(R.drawable.img3,"Hair wash")
        servicesList.add(service3)

        val service4 = Services(R.drawable.img4,"Hair treatment")
        servicesList.add(service4)
    }

}