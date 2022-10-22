package com.example.myapplication


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*

class RecylerAdapter(private val items: ArrayList<Studentlist>) :
    RecyclerView.Adapter<RecylerAdapter.ViewHolder>() {

    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_item,
                parent,
                false
            )
        )
    }

    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]

        holder.tvItem.text = item.name_student
        holder.tvclassid.text=item.class_id
        holder.tvmoblieno.text=item.mobileNo_student


        // Updating the background color according to the odd/even positions in list.
//        if (position % 2 == 0) {
//            holder.cardViewItem.setBackgroundColor(
//                ContextCompat.getColor(
//                    context,
//                    R.color.purple_700
//                )
//            )
//        } else {
//            holder.cardViewItem.setBackgroundColor(
//                ContextCompat.getColor(
//                    context,
//                    R.color.white
//                )
//            )
//        }
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        val tvItem: TextView = view.tv_item_name
        val tvclassid:TextView=view.tv_item_classid
        val tvmoblieno:TextView=view.mobileno

        val cardViewItem: CardView = view.card_view_item
    }
}