package com.example.besttodo.todoscreen.fragments

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.example.besttodo.R
import com.example.besttodo.databinding.FragmentClickerSheetBinding
import com.example.besttodo.todoscreen.model.CompleteTodo
import com.example.besttodo.todoscreen.model.TodoItem
import com.example.besttodo.todoscreen.viewmodel.CompleteViewModel
import com.example.besttodo.todoscreen.viewmodel.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ClickerSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentClickerSheetBinding
    private val args by navArgs<ClickerSheetFragmentArgs>()
    private lateinit var model: MainViewModel
    private lateinit var comModel: CompleteViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClickerSheetBinding.inflate(inflater, container , false)
        model = ViewModelProvider(this)[MainViewModel::class.java]
        comModel = ViewModelProvider(this)[CompleteViewModel::class.java]

        binding.delete.setOnClickListener {
            model.deleteTodo(args.todoValue)
            Toast.makeText(requireContext(), "Successfully deleted!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_clickerSheetFragment_to_rootFragment)

        }

        binding.completed.setOnClickListener {
            val todoItem = CompleteTodo(args.todoValue.id, args.todoValue.nameTodo, args.todoValue.descTodo)
            comModel.addComplete(todoItem)
            model.deleteTodo(args.todoValue)
            findNavController().navigate(R.id.action_clickerSheetFragment_to_rootFragment)
            Toast.makeText(requireContext(), "My wishes you got it!", Toast.LENGTH_SHORT).show()
        }

        binding.edit.setOnClickListener {
            binding.editField.visibility = View.VISIBLE
        }


        binding.editName.setText(args.todoValue.toString())
        binding.editDesc.setText(args.todoValue.descTodo)


        binding.editBtn.setOnClickListener{
            val name = binding.editName.text.toString()
            val desc = binding.editDesc.text.toString()

            if(inputCheck(name, desc) && name != args.todoValue.nameTodo || desc != args.todoValue.descTodo){
                val updateTodo = TodoItem(args.todoValue.id, name, desc)
                model.updateTodo(updateTodo)
                Toast.makeText(requireContext(), "Updated!)", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_clickerSheetFragment_to_rootFragment)
            } else {
                Toast.makeText(requireContext(), "Fields are empty or same before update! ", Toast.LENGTH_SHORT).show()
            }


        }





        return binding.root
    }

    private fun inputCheck(name: String, desc: String): Boolean{
        return name.isNotEmpty() && desc.isNotEmpty()
    }

}