package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activitytest.databinding.ThirdLayoutBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ThirdLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.third_layout)
        setContentView(binding.root)
    }
}