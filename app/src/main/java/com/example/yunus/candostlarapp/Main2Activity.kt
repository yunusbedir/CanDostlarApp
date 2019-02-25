package com.example.yunus.candostlarapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var intent = getIntent()
        var resim:Int
        var ad:String
        if (intent != null){
            imageView.setImageResource(intent.getIntExtra("imgResouce",R.drawable.kedi_1))
            textView.text = intent.getStringExtra("tvText")
        }



    }
}
