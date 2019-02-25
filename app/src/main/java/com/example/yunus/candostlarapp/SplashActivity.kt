package com.example.yunus.candostlarapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


    }

    override fun onResume() {
        super.onResume()
        object : CountDownTimer(3000,1000){
            //3000 milisaniye bittiğinde çalışacak olan metod
            override fun onFinish() {
                intent = Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)
            }
            //3000 milisaniye içinde her 1000 milisaniyede bir çalışacak metod
            override fun onTick(p0: Long) {

            }

        }.start()
    }
}
