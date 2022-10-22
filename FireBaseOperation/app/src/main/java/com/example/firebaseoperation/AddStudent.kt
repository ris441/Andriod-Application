package com.example.firebaseoperation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_add_student.*

class AddStudent : AppCompatActivity() {
    private lateinit var database: DatabaseReference
//    private lateinit var btn_save: Button
//    lateinit var et_enroll:EditText
//    lateinit var et_class:EditText
//    private  lateinit var et_name: EditText
//    private  lateinit var etSurname: EditText
//    private  lateinit var etEmail: EditText
//    lateinit var btn_home:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        database = Firebase.database.reference

//        etEmail=findViewById(R.id.etEmail)
//        et_enroll=findViewById(R.id.et_enroll)
//        et_class=findViewById(R.id.et_class)
//        et_name = findViewById(R.id.et_name)
//        etSurname=findViewById(R.id.etSurname)
//        btn_save=findViewById(R.id.btn_save)
//        btn_home=findViewById(R.id.btn_home)
        btn_save.setOnClickListener(){
            val sName=et_name.text.toString().trim()
            val sur=etSurname.text.toString().trim()
            val email=etEmail.text.toString().trim()
            val enroll=et_enroll.text.toString().trim()
            val stdclass=et_class.text.toString().trim()

            val userMap= hashMapOf(
                "name" to sName,
                "Surname" to sur,
                "Enrollment" to enroll,
                "class" to stdclass,
                "EmailAddress" to email
            )
            database.root.child("StudentList").push().setValue(userMap)
//            .addOnCompleteListener(new  OnCompleteListener<DocumentSnapshot>() {
//            public void OnComplete(){
//
//                Toast.makeText(this, "Data is Saved to Firebase", Toast.LENGTH_SHORT).show()
//            }
//        })

            et_name.setText("")
            etSurname.setText("")
            etEmail.setText("")
            et_enroll.setText("")
            et_class.setText("")
        }

        btn_home.setOnClickListener(){
            val switchActivityIntent = Intent(this, homepage::class.java)
            startActivity(switchActivityIntent)
        }

    }
}