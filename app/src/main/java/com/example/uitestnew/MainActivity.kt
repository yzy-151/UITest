package com.example.uitestnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonSignIn:Button=findViewById(R.id.buttonSignIn)

        buttonSignIn.setOnClickListener {
            val intent=Intent(this,MainInterface::class.java)
            startActivity(intent)
        }

    }
}