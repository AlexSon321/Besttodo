package com.example.besttodo.todoscreen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.besttodo.R
import com.example.besttodo.todoscreen.adapters.CompleteAdapter
import com.example.besttodo.databinding.FragmentCompletedBinding
import com.example.besttodo.todoscreen.viewmodel.CompleteViewModel
import com.example.besttodo.todoscreen.viewmodel.MainViewModel


class CompletedFragment : Fragment() {
    private lateinit var binding: FragmentCompletedBinding
    private lateinit var model: CompleteViewModel
    private var adapter = CompleteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompletedBinding.inflate(inflater, container, false)

        model = ViewModelProvider(this)[CompleteViewModel::class.java]

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity as AppCompatActivity)



        model.completeList.observe(viewLifecycleOwner){
            adapter.addElem(it)
        }

        binding.deleteBtn.setOnClickListener {
            model.deleteAll()
            Toast.makeText(requireContext(), "Successfully deleted!", Toast.LENGTH_SHORT).show()
        }



        return binding.root
    }


}