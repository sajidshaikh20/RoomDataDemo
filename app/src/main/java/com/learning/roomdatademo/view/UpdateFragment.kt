package com.learning.roomdatademo.view

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.learning.roomdatademo.R
import com.learning.roomdatademo.databinding.FragmentUpdateBinding
import com.learning.roomdatademo.model.User
import com.learning.roomdatademo.viewmodel.UserViewModel


class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var useerViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_update, container, false)

        useerViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        binding.edtUpateName.setText(args.currentuser.firstName)
        binding.edtUpateLastName.setText(args.currentuser.LastName)
        binding.edtUpdateage.setText(args.currentuser.age)


        binding.mbtnupdate.setOnClickListener {
            updateItem()
        }
        binding.btndelete.setOnClickListener {
            deleteUser()
        }

        return binding.root
    }

    private fun updateItem() {
        val firstname = binding.edtUpateName.text.toString()
        val lastName = binding.edtUpateLastName.text.toString()
        val age = binding.edtUpdateage.text.toString()
        if (inputCheck(firstname, lastName, age)) {
            val updateUser = User(args.currentuser.id, firstname, lastName, age)

            useerViewModel.updateUser(updateUser)

            findNavController().navigate(R.id.action_updateFragment_to_homeFragment)
            Toast.makeText(requireContext(), "Update!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "All field required", Toast.LENGTH_SHORT).show()
        }
    }

    fun inputCheck(ufirstname: String, ulastName: String, uage: String): Boolean {
        return !(TextUtils.isEmpty(ufirstname) && TextUtils.isEmpty(ulastName) && uage.isEmpty())
    }
    fun deleteUser() {
        useerViewModel.deleteUser(args.currentuser)
        findNavController().navigate(R.id.action_updateFragment_to_homeFragment)
    }
}