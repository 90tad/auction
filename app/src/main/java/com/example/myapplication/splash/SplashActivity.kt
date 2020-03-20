package com.example.myapplication.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.sign_in.SignInActivity

class SplashActivity : AppCompatActivity() {

    companion object {
        const val DELAY_MILI: Long = 500
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val intent = SignInActivity.getInstance(this)
        Handler()
            .postDelayed({
                startActivity(intent)
                finish()
            }, DELAY_MILI)
    }
}
