package com.example.besttodo.firebasescreen.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.besttodo.R
import com.example.besttodo.databinding.FragmentFireBaseBinding
import com.example.besttodo.firebasescreen.adapters.FireBaseAdapter
import com.example.besttodo.firebasescreen.model.FireBase
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore


class FireBaseFragment : Fragment(){
    private lateinit var binding: FragmentFireBaseBinding
    private lateinit var fireList: ArrayList<FireBase>
    private lateinit var dbRef: DatabaseReference
    private lateinit var fireStore: FirebaseFirestore
    private  var adapter = FireBaseAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFireBaseBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(activity as AppCompatActivity)

        fireList = arrayListOf<FireBase>()

        binding.recyclerView.adapter = adapter

        fireStore = FirebaseFirestore.getInstance()

        dbRef = FirebaseDatabase.getInstance().getReference("Users")


        binding.search.setOnQueryTextListener( object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {

                customSearch(newText!!)

                return true
            }
        }
        )



        dbRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                fireList.clear()

                if(snapshot.exists()){
                    for(empSnap in snapshot.children){
                        val empData = empSnap.getValue(FireBase::class.java)
                        fireList.add(empData!!)
                    }

                    adapter.addElem(fireList)

                    }

            }

            override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(requireContext(), "Something wrong!?", Toast.LENGTH_SHORT).show()
            }
        })




        return binding.root
    }


    private fun customSearch(str: String){
     val searchQuery = FirebaseDatabase.getInstance().getReference("Users").orderByChild("empName")
         .startAt(str)
         .endAt(str + "\uf8ff")

    searchQuery.addValueEventListener(object : ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            fireList.clear()
            if(snapshot.exists()){
                for (snap in snapshot.children){
                    if(snap.getValue(FireBase::class.java) ==  null){
                        Toast.makeText(requireContext(), "NULL", Toast.LENGTH_SHORT).show()
                    } else {
                        val empData = snap.getValue(FireBase::class.java)
                        fireList.add(empData!!)

                    }

                    adapter.addElem(fireList)

                }


            }

        }

        override fun onCancelled(error: DatabaseError) {

        }

    })


}




}