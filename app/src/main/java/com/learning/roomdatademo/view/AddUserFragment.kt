package com.learning.roomdatademo.view

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.learning.roomdatademo.R
import com.learning.roomdatademo.databinding.FragmentAddUserBinding
import com.learning.roomdatademo.model.User
import com.learning.roomdatademo.viewmodel.UserViewModel

class AddUserFragment : Fragment() {

    private lateinit var binding: FragmentAddUserBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddUserBinding.inflate(inflater)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.mbtnAdd.setOnClickListener {
            instetDataToDatabase()


        }
        return binding.root
    }

    private fun instetDataToDatabase() {

        val firstname = binding.edtName.text.toString()
        val lastName = binding.edtLastName.text.toString()
        val age = binding.edtage.text.toString()

        if (inputCheck(firstname, lastName, age)) {
//Create user object
            val user = User(0, firstname, lastName, age)
            //view modelu
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "Added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addUserFragment_to_homeFragment)
        }else{
            Toast.makeText(requireContext(), "Added", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: String): Boolean {

        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }


//    fun insertData() {
//        val firstName = binding.edtName.text.toString()
//        val lastName = binding.edtLastName.text.toString()
//        val user = User(firstName = firstName, LastName = lastName)
//        val dataBase = AppDataBase(requireContext().applicationContext)
//        CoroutineScope(Dispatchers.IO).launch {
//            UserRepository(dataBase).insertUser(user)
//        }


}

