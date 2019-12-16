package com.coder.mm.progressbar_01

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var i=0


    var bol=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        increasePercent()
        button.setOnClickListener {

            bol=!bol
            if(bol){
                progressBar.visibility=View.GONE
            }else{
                progressBar.visibility=View.VISIBLE
            }

        }

        goToSecond.setOnClickListener {
            bol = !bol
            var intent=Intent(this@MainActivity, Second::class.java)

                startActivity(intent)

        }

        customToast.setOnClickListener {


            var layout = layoutInflater.inflate(R.layout.custom_toast,null,false )
            var toast= Toast.makeText(applicationContext,"Toast",Toast.LENGTH_LONG)
            toast.view=layout
           toast.setGravity(Gravity.CENTER,0,0)
            toast.show()

        }

        btnSendMessage.setOnClickListener {

            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.SEND_SMS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.SEND_SMS), 101
                )
            } else {
                sendSms()
            }
        }

    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == 101) sendSms()
    }

    private fun sendSms() {
        val number="09"
        val text="Hello,Text Message !"
        SmsManager.getDefault().sendTextMessage(number,"09",text,null,null)

        Toast.makeText(this,"Message send success !",Toast.LENGTH_LONG).show()
    }
    fun increasePercent(){
        Thread(Runnable {

            for(i in 1.until(101)){
                Log.d("my_msg",i.toString())
                Thread.sleep(100)
                textView.text = "$i %"
            }
        }).start()
    }




}


