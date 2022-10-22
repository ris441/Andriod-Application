package com.example.firebaseoperation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var btn_save:Button
    private  lateinit var et_name:EditText
    private  lateinit var etSurname:EditText
    private  lateinit var etEmail:EditText
    lateinit var btn_home:Button
//

//    private lateinit var binding : ActivityMainBinding


    // ...
//     database = Firebase.database.reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Firebase.database.reference

        etEmail=findViewById(R.id.etEmail)
        et_name = findViewById(R.id.et_name)
        etSurname=findViewById(R.id.etSurname)
        btn_save=findViewById(R.id.btn_save)
        btn_home=findViewById(R.id.btn_home)
        btn_save.setOnClickListener(){
            val sName=et_name.text.toString().trim()
            val sur=etSurname.text.toString().trim()
            val email=etEmail.text.toString().trim()
            val userMap= hashMapOf(
                "name" to sName,
                "Surname" to sur,
                "EmailAddress" to email
            )
            database.root.child("Teacher").child(userMap.get("name").toString()).setValue(userMap)
//            .addOnCompleteListener(new  OnCompleteListener<DocumentSnapshot>() {
//            public void OnComplete(){
//
//                Toast.makeText(this, "Data is Saved to Firebase", Toast.LENGTH_SHORT).show()
//            }
//        })

           et_name.setText("")
            etSurname.setText("")
           etEmail.setText("")
        }

        btn_home.setOnClickListener(){
            val switchActivityIntent = Intent(this, homepage::class.java)
            startActivity(switchActivityIntent)
        }

    }

}


