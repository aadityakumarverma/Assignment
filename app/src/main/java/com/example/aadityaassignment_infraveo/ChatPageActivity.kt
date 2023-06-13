package com.example.aadityaassignment_infraveo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aadityaassignment_infraveo.databinding.ActivityChatPageBinding

class ChatPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityChatPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvPersonName.text=intent.getStringExtra("passName")


    }
}