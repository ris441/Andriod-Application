package com.example.firebaseoperation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*

class MyAdapter(private val stdlist :ArrayList<StudentPerson>):RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{ override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.person,parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val currentItem = stdlist[position]
        holder.rollno.text=currentItem.rollno
//        holder.firstname.text=currentItem.firstname
//        holder.lastname.text=currentItem.surname
//        holder.std_class.text=currentItem.std_class
//        holder.std_ttatd.text=currentItem.ttatd
//        holder.attd.text=currentItem.attend

    }

    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
        return stdlist.size
    }


    class MyViewHolder( itemView: View): ViewHolder(itemView) {

        val rollno : TextView = itemView.findViewById(R.id.rollno)
    }



//    class MyViewHolder(itemView:View): ViewHolder(itemView) {
//        val rollno : TextView = itemView.findViewById(R.id.rollno)
//        val firstname : TextView = itemView.findViewById(R.id.firstname)
//        val lastname : TextView = itemView.findViewById(R.id.lastname)
//        val std_class : TextView = itemView.findViewById(R.id.std_class)
//        val std_ttatd : TextView = itemView.findViewById(R.id.std_ttatd)
//        val attd : TextView = itemView.findViewById(R.id.attd)
//
//
//
//
//
//    }

}
