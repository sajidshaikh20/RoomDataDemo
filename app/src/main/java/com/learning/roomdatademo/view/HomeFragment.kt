package com.learning.roomdatademo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.learning.roomdatademo.R
import com.learning.roomdatademo.databinding.FragmentHomeBinding
import com.learning.roomdatademo.view.adapter.ListAdapter
import com.learning.roomdatademo.view.handler.HomeClickHandler
import com.learning.roomdatademo.viewmodel.UserViewModel


class HomeFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        //Recyclerview
        val adapter = ListAdapter()
        binding.rcvAvRoomView.adapter = adapter

        //UserViewHolder
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })


//        binding.btnaddUser.setOnClickListener {
//            findNavController().navigate(R.id.action_homeFragment_to_addUserFragment)
//        }
        binding.btndeleteALl.setOnClickListener {
            deleteAll()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.handler = HomeClickHandler(this)
    }

    fun deleteAll() {
        userViewModel.deleteAllUser()
        Toast.makeText(requireContext(), "Delete All", Toast.LENGTH_SHORT).show()

    }

}