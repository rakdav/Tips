package com.example.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.example.activities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var tipProcent:Int=0
    private var sum:Double=0.0
    private var total:Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.editTextSum.addTextChangedListener(object:TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().isNotEmpty()) {
                    sum = s.toString().toDouble()
                    tipProcent = binding.seekBarTip.progress
                    total = sum + (sum * tipProcent / 100)
                    Log.d("procent", tipProcent.toString())
                    Log.d("total", total.toString())
                }
            }
            override fun afterTextChanged(s: Editable?) {

            }

        })
        binding.seekBarTip.setOnSeekBarChangeListener(object:OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(binding.editTextSum.text.toString().isNotEmpty()) {
                    tipProcent=progress
                    sum = binding.editTextSum.text.toString().toDouble()
                    total = sum + (sum * progress / 100)
                    Log.d("total", total.toString())
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        binding.buttonSend.setOnClickListener {
            val intent=Intent(baseContext,TipActivity::class.java)
            intent.putExtra(TIP_PROCENT,tipProcent)
            intent.putExtra(SUM,sum)
            intent.putExtra(TOTAL,total)
           // startActivity(intent)
            StartForResult.launch(intent)
        }
    }
    companion object{
        val TIP_PROCENT="tipProcent"
        val SUM="sum"
        val  TOTAL="total"
        val MESSAGE="message"
    }
    private val StartForResult =registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
        {
            result:ActivityResult->
            run {
                if (result.resultCode == Activity.RESULT_OK) {
                    val intent = result.data
                    val mes = intent?.getStringExtra(MESSAGE)
                    if(mes.equals("OK"))
                        binding.imageView.setImageResource(R.drawable.ok)
                }
                else
                    binding.imageView.setImageResource(R.drawable.cancel)
            }
        }
       )
}