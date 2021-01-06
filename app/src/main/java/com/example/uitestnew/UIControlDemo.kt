package com.example.uitestnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import org.w3c.dom.Text

class UIControlDemo : AppCompatActivity() , View.OnClickListener{          //传入一个接口必须对其进行重写
    var button: Button?=null
    var imageView: ImageView?=null
    var textview:TextView?=null
    var progressBar:ProgressBar?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_control_demo)
        textview=findViewById<TextView>(R.id.textView)
        button=findViewById<Button>(R.id.button4)
        imageView=findViewById<ImageView>(R.id.imageView)
        progressBar=findViewById(R.id.progressBar2)
        button?.setOnClickListener(this)
//        欧拉欧拉欧拉，，，byid只能在oncreate里面用，我理解了
    }

    override fun onPause() {
        super.onPause()
        textview?.setText("你的程序进入后台了哈哈哈")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button4->{
                textview?.setText("你点击了按钮")
                imageView?.setImageResource(R.drawable.mao)
            }
            R.id.button5->{
                progressBar!!.progress=progressBar!!.progress+10
            }
        }
    }
}