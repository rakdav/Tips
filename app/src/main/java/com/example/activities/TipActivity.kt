package com.example.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activities.databinding.ActivityMainBinding
import com.example.activities.databinding.ActivityTipBinding

class TipActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTipBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTipBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(intent.extras!=null){
            binding.textViewProcent.text= intent.extras!!.getInt("tipProcent").toString()
            binding.textViewSum.text=intent.extras!!.getDouble("sum").toString()
            binding.textViewTotal.text=intent.extras!!.getDouble("total").toString()
        }
    }
}