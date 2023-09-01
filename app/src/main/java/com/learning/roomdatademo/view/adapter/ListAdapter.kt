package com.learning.roomdatademo.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Constraints
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.learning.roomdatademo.R
import com.learning.roomdatademo.model.User
import com.learning.roomdatademo.view.HomeFragmentDirections
import kotlin.math.log

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.usercard, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = userList[position]
       // holder.itemView.findViewById<TextView>(R.id.mtvid).text = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.mtvname).text = currentItem.firstName.toString()
        holder.itemView.findViewById<TextView>(R.id.mtvlastname).text =
            currentItem.LastName.toString()
        holder.itemView.findViewById<TextView>(R.id.mtvage).text = currentItem.age.toString()

//        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setOnClickListener {
//            Log.i("sajid", "onBindViewHolder: row layout")
//            val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment(currentItem)
//            holder.itemView.findNavController().navigate(action)
//        }
        holder.itemView.findViewById<ImageView>(R.id.ivedit).setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()

    }
}