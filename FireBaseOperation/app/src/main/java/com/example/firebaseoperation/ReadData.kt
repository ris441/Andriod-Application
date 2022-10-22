package com.example.firebaseoperation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseoperation.databinding.ActivityReadDataBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ReadData : AppCompatActivity() {

    private lateinit var binding : ActivityReadDataBinding
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding =ActivityReadDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.readdataBtn.setOnClickListener{
            val userName: String  = binding.etusername.text.toString()
            val searchName: String = binding.etsearchid.text.toString()
            if(userName.isNotEmpty()){
                readData(userName,searchName,binding)
            }
            else{
                Toast.makeText(this, "Please Enter Teacher Name", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun readData(userName: String, searchName: String, binding: ActivityReadDataBinding) {
       database=FirebaseDatabase.getInstance().getReference(userName)
        database.child(searchName).get().addOnSuccessListener {
            if(it.exists()){
                val name=it.child("name").value
                val surname=it.child("Surname").value
                val email = it.child("EmailAddress").value
                Toast.makeText(this,"Data Successfully Fetched ",Toast.LENGTH_SHORT).show()
                binding.etusername.setText("")
                binding.etsearchid.setText("")
                binding.tvName.text=name.toString()
                binding.tvSurname.text=surname.toString()
                binding.tvEmail.text=email.toString()
            }
            else{
                Toast.makeText(this,"Teacher Doesn't Exist",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }


}