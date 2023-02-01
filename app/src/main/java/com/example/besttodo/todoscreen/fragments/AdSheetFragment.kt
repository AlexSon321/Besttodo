package com.example.besttodo.todoscreen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.besttodo.R
import com.example.besttodo.databinding.FragmentAdSheetBinding
import com.example.besttodo.todoscreen.model.TodoItem
import com.example.besttodo.todoscreen.viewmodel.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class AdSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAdSheetBinding
    private lateinit var model: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdSheetBinding.inflate(inflater, container, false)
        model = ViewModelProvider(this)[MainViewModel::class.java]

        binding.button2.setOnClickListener {
            val name = binding.nameField.text.toString()
            val desc = binding.descField.text.toString()

            if(inputCheck(name, desc)){
                val todoItem = TodoItem(null, name, desc)
                model.addTodo(todoItem)
                findNavController().navigate(R.id.action_adSheetFragment_to_rootFragment)
            } else {
                Toast.makeText(requireContext(), "Fill all field's!", Toast.LENGTH_SHORT).show()
            }


        }




        return binding.root
    }


    private fun inputCheck(name: String, desc: String): Boolean{
        return name.isNotEmpty() && desc.isNotEmpty()
    }

}