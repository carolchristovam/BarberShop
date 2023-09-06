package com.example.barbershop

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.barbershop.databinding.ActivityMainBinding
import com.example.barbershop.view.Home
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btLogin.setOnClickListener {
            val name = binding.editName.text.toString()
            val password = binding.editPassword.text.toString()

            when {
                name.isEmpty() -> {
                    message(it, "Name cannot be empty")
                }

                password.isEmpty() -> {
                    message(it, "Please input your password")
                }
                password.length <= 6 -> {
                    message(it,"Password must have at least 6 characters")
                }
                else -> {
                    goHome(name)
                }
            }


        }
    }

    private fun message(view: View, message: String) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()

    }

    private fun goHome (name:String){
        val intent = Intent(this, Home::class.java)
        intent.putExtra("name",name)
        startActivity(intent)
    }
}

