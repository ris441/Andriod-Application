package com.example.firebaseoperation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_homepage.*


class homepage : AppCompatActivity() {
    lateinit var btn_user:Button
//    lateinit var btn_std:Button
    lateinit var  btn_show:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        btn_user=findViewById(R.id.btn_user)
//        btn_std=findViewById(R.id.btn_std)
        btn_show=findViewById(R.id.btn_show)
        btn_user.setOnClickListener(){
            val switchActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(switchActivityIntent)
            Toast.makeText(this, "Login as Admin", Toast.LENGTH_SHORT).show()
        }
        btn_std.setOnClickListener(){

            val switchActivityIntent = Intent(this, AddStudent::class.java)
            startActivity(switchActivityIntent)
            Toast.makeText(this,"Login as User",Toast.LENGTH_SHORT).show()
        }
        btn_show.setOnClickListener(){
            val switchActivityIntent=Intent(this,ReadData::class.java)
            startActivity(switchActivityIntent)
            Toast.makeText(this,"check Teacher Data",Toast.LENGTH_SHORT).show()
        }
        attendance.setOnClickListener(){
            val switchActivityIntent=Intent(this,takeAttendence::class.java)
            startActivity(switchActivityIntent)
            Toast.makeText(this,"Student List",Toast.LENGTH_SHORT).show()
        }

    }
}