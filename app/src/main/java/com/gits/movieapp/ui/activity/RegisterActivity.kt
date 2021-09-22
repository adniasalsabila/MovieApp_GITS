package com.gits.movieapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.gits.movieapp.R

class RegisterActivity : AppCompatActivity() {
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        button = findViewById(R.id.buttonRegister)
        button.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}