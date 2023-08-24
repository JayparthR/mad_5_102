package com.example.mad_5_102

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            impintent()
    }
    fun impintent(){
        findViewById<Button>(R.id.btn_url).setOnClickListener {
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(findViewById<EditText>(R.id.e_url).text.toString())).also { startActivity(it)
                }

            findViewById<Button>(R.id.btn_call).setOnClickListener {
            var number = findViewById<EditText>(R.id.e_phone).text.toString().trim()
                Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel : $number")).apply { startActivity(this) }
            }

            findViewById<Button>(R.id.btn_call_log).setOnClickListener {
                Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
            }

            findViewById<Button>(R.id.btn_gallery).setOnClickListener {
                Intent(Intent.ACTION_VIEW).setType("Image/*").also { startActivity(it) }
            }

            findViewById<Button>(R.id.btn_camera).setOnClickListener {
                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }

            }

            findViewById<Button>(R.id.btn_alarm).setOnClickListener {
                Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
            }


        }
    }

}