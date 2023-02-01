package com.example.besttodo.firebasescreen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.besttodo.R
import com.example.besttodo.databinding.FragmentFireAddBinding
import com.example.besttodo.firebasescreen.model.FireBaseComment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class FireAddFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentFireAddBinding
    private lateinit var reference: DatabaseReference
    private val args by navArgs<FireAddFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFireAddBinding.inflate(inflater, container , false)

        reference = FirebaseDatabase.getInstance().getReference("Comments")


       binding.textView14.text = args.videoName

        binding.button3.setOnClickListener {
            val name = binding.editTextTextPersonName.text.toString()
            val comment = binding.editTextTextPersonName2.text.toString()

            if(inputCheck(name, comment)){
                val key = reference.push().key!!
                val fireBaseComment = FireBaseComment(key, name, binding.ratingBar2.rating, comment, args.videoName)
                reference.child(key).setValue(fireBaseComment)
                findNavController().navigate(R.id.action_fireAddFragment_to_fireRootFragment)
            }

        }

        return binding.root
    }


    private fun inputCheck(name: String, comment: String): Boolean{
        return name.isNotEmpty()  && comment.isNotEmpty()
    }



}



