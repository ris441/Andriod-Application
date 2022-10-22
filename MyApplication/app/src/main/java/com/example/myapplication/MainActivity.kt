package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main1.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var list:ArrayList<Studentlist>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        // Set the LayoutManager that this RecyclerView will use.
        recycler_view_items.layoutManager = LinearLayoutManager(this)
        recycler_view_items.setHasFixedSize(true)
        list = arrayListOf<Studentlist>()
        studentList()
        // Adapter class is initialized and list is passed in the param.
//        val itemAdapter = RecylerAdapter( list)

        // adapter instance is set to the recyclerview to inflate the items.
//        recycler_view_items.adapter = itemAdapter
    }

    /**
     * Function is used to get the Items List which is added in the list.
     */
    private fun getItemsList(): ArrayList<String> {
        val list = ArrayList<String>()

        for (i in 1..15) {
            list.add("Item $i")
        }

        return list
    }
    private fun studentList1(): ArrayList<Studentlist>{
        val list = ArrayList<Studentlist>()
        val item = Studentlist("Rakesh","2525242","12")
        list.add(item)
        return list

           }
    private fun studentList() {

       database = FirebaseDatabase.getInstance().getReference("Studentlist")
        database.addValueEventListener( object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (stdSnapshot in snapshot.children){
                        val std: Studentlist? = stdSnapshot.getValue(Studentlist::class.java)
                        with(list) {
                            add(std!!)
                        }
                    }
                    recycler_view_items.adapter=RecylerAdapter(list)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Error in Fetch data", Toast.LENGTH_SHORT).show()
            }

        })


//        return list
    }
}