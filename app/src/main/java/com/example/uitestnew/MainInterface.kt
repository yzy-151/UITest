package com.example.uitestnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainInterface : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_interface)

        val imageButton:ImageButton=findViewById(R.id.imageButton)
        imageButton.setOnClickListener {
            val intent=Intent(this,Test1_ImageView::class.java)
            startActivity(intent)
        }

        val schForum:Button=findViewById(R.id.button)
        schForum.setOnClickListener {
            val intent=Intent(this,UIControlDemo::class.java)
            startActivity(intent)
        }

        val schNews:Button=findViewById(R.id.button2)
        schNews.setOnClickListener {
            val intent=Intent(this,UIDemo2::class.java)
            startActivity(intent)
        }
    }
}