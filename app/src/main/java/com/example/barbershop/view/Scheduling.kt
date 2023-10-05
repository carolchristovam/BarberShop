package com.example.barbershop.view

import android.graphics.Color
import android.icu.util.Calendar

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.example.barbershop.databinding.ActivitySchedulingBinding
import com.google.android.material.snackbar.Snackbar

class Scheduling : AppCompatActivity() {

    private lateinit var binding: ActivitySchedulingBinding
    private val calendar = Calendar.getInstance();
    private var date: String = ""
    private var hour: String = ""

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchedulingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val name1 = intent.extras?.getString("name1").toString()

        val datePicker = binding.datePicker
        datePicker.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            var day = dayOfMonth.toString()
            val month: String

            if (dayOfMonth < 10) {
                day = "0$dayOfMonth"

            }
            if (monthOfYear < 10) {
                month = "" + (monthOfYear + 1)
            } else {
                month = (monthOfYear + 1).toString()
            }

            date = "$day / $month / $year"
        }

        binding.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->

            val minute2: String

            if (minute < 10) {
                minute2 = "0$minute"
            } else {
                minute2 = minute.toString()
            }

            hour="$hourOfDay:$minute2"
        }
        binding.timePicker.setIs24HourView(true)

        binding.btBook2.setOnClickListener {
            val barber1=binding.barber1
            val barber2=binding.barber2
            val barber3=binding.barber3

            when{
                hour.isEmpty() -> {
                    message(it, "Choose a time for your appointment!", "#FF00000")
                }
                hour < "8:00" && hour > "19:00" -> {
                    message(it, "Barber Shop is close - Opening hours from 8:00 to 19:00!", "#FF00000")
                }
                date.isEmpty() -> {
                    message(it, "Choose a date!", "#FF00000")
                }
                barber1.isChecked && date.isNotEmpty() && hour.isNotEmpty() -> {
                    message(it, "Appointment completed successfully!", "#FF03DAC5")
                }
                barber2.isChecked && date.isNotEmpty() && hour.isNotEmpty() -> {
                    message(it, "Appointment completed successfully!", "#FF03DAC5")
                }
                barber3.isChecked && date.isNotEmpty() && hour.isNotEmpty() -> {
                    message(it, "Appointment completed successfully!", "#FF03DAC5")
                }
                else -> {
                    message(it, "Choose a barber!", "#FF00000")
                }
            }
        }

    }

    private fun message (view:View, message:String, color: String){
        val snackbar=Snackbar.make(view,message,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor(color))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()

    }
}