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
            binding.textViewProcent.text= resources.getString(R.string.tip)+
                    intent.extras!!.getInt(MainActivity.TIP_PROCENT).toString()
            binding.textViewSum.text=resources.getString(R.string.sum)+
                    intent.extras!!.getDouble(MainActivity.SUM).toString()
            binding.textViewTotal.text=resources.getString(R.string.total)+
                    intent.extras!!.getDouble(MainActivity.TOTAL).toString()
        }
    }

}
