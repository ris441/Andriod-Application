package com.example.firebaseoperation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_take_attendence.*
import kotlinx.android.synthetic.main.person.*

class takeAttendence : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var newRecylerview: RecyclerView
    private lateinit var stdList: ArrayList<StudentPerson>
    private lateinit var rollno:TextView
//    private lateinit var roll : Array<String>
//    private lateinit var fname : Array<String>
//    private lateinit var lname : Array<String>
//    private lateinit var std : Array<String>
//    private lateinit var total:Array<String>

//    private lateinit var totalattd : Array<String>
//    private lateinit var attd : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_attendence)
    rollno=findViewById(R.id.rollno)
//        roll= arrayOf("45","85")
//        fname= arrayOf("Rim","jakk")
//        lname= arrayOf("Tako","mako")
//        std= arrayOf("0","23")
//        total= arrayOf("254","854")
        recyclerview.layoutManager=LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        stdList= arrayListOf()
        getStudentData()

//        newArrayList = arrayListOf<StudentPerson>()
//        getUserData()


    }

    private fun getStudentData() {
        recyclerview.visibility= View.GONE
        rollno.visibility=View.VISIBLE
         dbref = FirebaseDatabase.getInstance().getReference("StudentList")
        dbref.addValueEventListener(object: ValueEventListener{
            override fun  onDataChange(snapshot: DataSnapshot){
                stdList.clear()
                if(snapshot.exists())
                {
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(StudentPerson::class.java)
                        stdList.add(empData!!)
                    }
                    val mAdapter = MyAdapter(stdList)
                    recyclerview.adapter=mAdapter
                    recyclerview.visibility=View.VISIBLE
                    rollno.visibility=View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@takeAttendence, "Error in Database", Toast.LENGTH_SHORT).show()
            }

    })
    }

//    private fun getUserData() {
//        for(i in roll.indices){
//            val stdperson=StudentPerson(roll[i],fname[i],lname[i],std[i],total[i],"p")
//        }
//        recyclerview.adapter=MyAdapter(newArrayList)
//    }
}