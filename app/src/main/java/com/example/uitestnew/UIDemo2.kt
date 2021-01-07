package com.example.uitestnew

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi

class UIDemo2 : AppCompatActivity() ,View.OnClickListener,RadioGroup.OnCheckedChangeListener,
    SeekBar.OnSeekBarChangeListener,RatingBar.OnRatingBarChangeListener,CompoundButton.OnCheckedChangeListener {                                                             //注意接口变成了RadioGroup开头
    var textView:TextView?=null
    var leftBt:Button?=null
    var rightBt:Button?=null
    var sureBt:Button?=null
    var switch:Switch?=null
    var editText:EditText?=null
    var girlRadioBt:RadioButton?=null
    var mauseRadioBt:RadioButton?=null
    var progressBar:ProgressBar?=null
    var radioGroup:RadioGroup?=null
    var checkboxGaoShu:CheckBox?=null
    var checkBoxXianDai:CheckBox?=null
    var checkBoxJiDao:CheckBox?=null
    var ratingBar:RatingBar?=null
    var imageView:ImageView?=null
    var seekBar:SeekBar?=null
    var GaoShu:String?=null
    var XianDai:String?=null
    var JiDao:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_demo2)
        textView = findViewById<TextView>(R.id.textView4)
        leftBt = findViewById<Button>(R.id.button8)
        rightBt = findViewById<Button>(R.id.button9)
        sureBt = findViewById<Button>(R.id.button10)
        switch = findViewById(R.id.switch3)
        editText = findViewById(R.id.editTextNumber2)
        girlRadioBt = findViewById<RadioButton>(R.id.radioButton5)
        mauseRadioBt = findViewById<RadioButton>(R.id.radioButton4)
        progressBar = findViewById<ProgressBar>(R.id.progressBar5)
        checkboxGaoShu = findViewById<CheckBox>(R.id.checkBox2)
        checkBoxXianDai = findViewById<CheckBox>(R.id.checkBox3)
        checkBoxJiDao = findViewById<CheckBox>(R.id.checkBox4)
        ratingBar = findViewById<RatingBar>(R.id.ratingBar2)
        radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        imageView = findViewById<ImageView>(R.id.imageView4)
        seekBar = findViewById<SeekBar>(R.id.seekBar3)

        leftBt?.setOnClickListener(this)
        rightBt?.setOnClickListener(this)
        sureBt?.setOnClickListener(this)
        radioGroup?.setOnCheckedChangeListener(this)
        seekBar?.setOnSeekBarChangeListener(this)
        ratingBar?.setOnRatingBarChangeListener(this)
        //this的含义是，这个activity，既然这个类接上了RatingBar。on。。接口，那它就等价于这个接口，this代指这个接口
        switch?.setOnCheckedChangeListener(object:CompoundButton.OnCheckedChangeListener{          //checkbox和switch很类似啊
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked){
                    textView?.setText("开")
                }else{
                    textView?.setText("关")
                }
            }
        })
        checkBoxXianDai?.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {   //记住吧，不理解怎么回事
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked) {
                    XianDai = "线代"
                } else {
                    XianDai = " "
                }
                textView?.setText(GaoShu + XianDai + JiDao)
            }
        })

        checkboxGaoShu?.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked) {
                    GaoShu = "高数"
                } else {
                    GaoShu = " "
                }
                textView?.setText(GaoShu + XianDai + JiDao)
            }
        })

        checkBoxJiDao?.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked) {
                    JiDao = "计导"
                } else {
                    JiDao = " "
                }
                textView?.setText(GaoShu + XianDai + JiDao)
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.N)              //在第63行true被要求加上这个，实际上只起到了忽略错误的作用
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button8->{
                textView?.setText("左")
            }
            R.id.button9->{
                textView?.setText("右")
            }
            R.id.button10->{
            var context=editText?.text.toString()       //获取输入框内容转换成字符串类型
            if (TextUtils.isEmpty(context)) {            //判断是否为空
                context = "0"                          //空就为0
            }
            progressBar?.setProgress(Integer.valueOf(context),true) //setProgress接收整数，因此来个封装型，转换成整数,ture表示动态，false表示静态
            }                                            //不写默认时false，并且这个方法支持API最低为24.我的是19，也无法实现
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {  //重写了oncheckedchanged方法
        if (checkedId==R.id.radioButton5){
            imageView?.setImageResource(R.drawable.q)
        }else{
            imageView?.setImageResource(R.drawable.mao)
        }
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        textView?.setText(progress.toString())     //修改文本框的内容，转化成能输出的字符形式输出
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {          //记得把弹出的黄色字体删掉，否则程序会死掉
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {            //这俩都是搞接口时弹出来不得不加上的
    }

    override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
        textView?.setText(rating.toString())
        Toast.makeText(this,rating.toString(),Toast.LENGTH_SHORT).show()//传入的参数是Float类rating，转化成String类后输出
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
    }
}

