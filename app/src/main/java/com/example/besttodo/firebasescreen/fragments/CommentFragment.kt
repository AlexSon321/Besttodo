package com.example.besttodo.firebasescreen.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.besttodo.databinding.FragmentCommentBinding
import com.example.besttodo.firebasescreen.adapters.FireCommentAdapter
import com.example.besttodo.firebasescreen.model.FireBaseComment
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList


class CommentFragment : Fragment() {
    private lateinit var binding: FragmentCommentBinding
    private lateinit var dataList: ArrayList<FireBaseComment>
    private var adapter = FireCommentAdapter()
    private lateinit var reference: DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommentBinding.inflate(inflater, container, false)



        binding.button5.setOnClickListener {
            searchCustom("Java")
        }

        binding.button6.setOnClickListener {
            searchCustom("Kotlin")
        }


        binding.button7.setOnClickListener {
            searchCustom("JavaScript")
        }



        dataList = arrayListOf<FireBaseComment>()



        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        binding.search.setOnQueryTextListener( object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {

                searchCustom(newText!!)

                return true
            }
        }
        )

        reference = FirebaseDatabase.getInstance().getReference("Comments")

        reference.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()


                if(snapshot.exists()){
                    for (snap in snapshot.children){
                        if(snap.getValue(FireBaseComment::class.java) ==  null){
                            Toast.makeText(requireContext(), "NULL", Toast.LENGTH_SHORT).show()
                        } else {
                            val empData = snap.getValue(FireBaseComment::class.java)
                            dataList.add(empData!!)

                        }

                       adapter.addElem(dataList)

                    }


                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Something wrong!?", Toast.LENGTH_SHORT).show()
            }

        })




        return binding.root
    }


    private fun searchCustom(str: String){
        val searchQuery = FirebaseDatabase.getInstance().getReference("Comments").orderByChild("videoName")
            .startAt(str).endAt(str + "\uf8ff")



        searchQuery.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                if(snapshot.exists()){
                    for (snap in snapshot.children){
                        if(snap.getValue(FireBaseComment::class.java) ==  null){
                            Toast.makeText(requireContext(), "NULL", Toast.LENGTH_SHORT).show()
                        } else {
                            val empData = snap.getValue(FireBaseComment::class.java)
                            dataList.add(empData!!)

                        }

                        adapter.addElem(dataList)

                    }


                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }



}