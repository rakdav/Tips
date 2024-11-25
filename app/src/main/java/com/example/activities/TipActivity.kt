package com.example.activities

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
            binding.buttonOk.setOnClickListener {
                val data=Intent()
                data.putExtra(MainActivity.MESSAGE,"OK")
                setResult(RESULT_OK,data)
                finish()
            }
            binding.buttonCancel.setOnClickListener {
                val data=Intent()
                data.putExtra(MainActivity.MESSAGE,"Cancel")
                setResult(RESULT_CANCELED,data)
                finish()
            }
            binding.buttonPhone.setOnClickListener {
                //startActivity(Intent(Intent.ACTION_CALL, Uri.parse("+79520503549")))

//                val url = "https://mail.ru"
//                val address = Uri.parse(url)
//                val urlIntent = Intent(Intent.ACTION_VIEW, address)
//                if (urlIntent.resolveActivity(packageManager) != null)
//                    startActivity(urlIntent)
//                else Log.d("Intent", "Intent (ACTION_VIEW) не обработан!")

//                val toSms="smsto:+79520503549"
//                val mes="Masha"
//                val sms=Intent(Intent.ACTION_SENDTO, Uri.parse(toSms))
//                sms.putExtra("sms_body",mes)
//                startActivity(sms)
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                try {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                } catch (e: ActivityNotFoundException) {
                    // display error state to the user
                }
            }
        }
    }
    companion object{
     val REQUEST_IMAGE_CAPTURE=1
    }

}
