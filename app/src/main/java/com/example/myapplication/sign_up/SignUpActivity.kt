package com.example.myapplication.sign_up

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class SignUpActivity : AppCompatActivity() {

    companion object {
        fun getInstance(context: Context): Intent = Intent(context, SignUpActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }
}
