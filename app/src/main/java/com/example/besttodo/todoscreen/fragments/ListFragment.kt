package com.example.besttodo.todoscreen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.besttodo.R
import com.example.besttodo.todoscreen.adapters.ListAdapter
import com.example.besttodo.databinding.FragmentListBinding
import com.example.besttodo.todoscreen.viewmodel.MainViewModel


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var model: MainViewModel
    private val adapter = ListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container , false)
        model = ViewModelProvider(this)[MainViewModel::class.java]
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity as AppCompatActivity)

        model.todoList.observe(viewLifecycleOwner){
            adapter.addElem(it)
        }

        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_rootFragment_to_adSheetFragment)
        }





        return binding.root
    }

}