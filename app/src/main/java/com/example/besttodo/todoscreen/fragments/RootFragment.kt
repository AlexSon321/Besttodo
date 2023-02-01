package com.example.besttodo.todoscreen.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.besttodo.R
import com.example.besttodo.todoscreen.adapters.ViewPagerAdapter
import com.example.besttodo.databinding.FragmentRootBinding
import com.google.android.material.tabs.TabLayoutMediator


class RootFragment : Fragment() {
    private lateinit var binding: FragmentRootBinding
    private var ctx: Context?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRootBinding.inflate(inflater, container ,false)


        Handler(Looper.myLooper() !!).postDelayed({
            binding.animationView.visibility = View.GONE

            binding.vPager.visibility = View.VISIBLE
            binding.tabLayout.visibility = View.VISIBLE
            binding.floatingActionButton3.visibility = View.VISIBLE
        }, 1500)

       binding.vPager.adapter = ViewPagerAdapter(context as FragmentActivity)
       binding.tabLayout.tabIconTint = null

       TabLayoutMediator(binding.tabLayout, binding.vPager){
           tab,pos ->
            when(pos){
                0 -> tab.setIcon(R.drawable.ic_baseline_edit_24)
                1 -> tab.setIcon(R.drawable.ic_baseline_done_all_24)
            }
       }.attach()





        return binding.root
    }

}