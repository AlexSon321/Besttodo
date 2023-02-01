package com.example.besttodo.firebasescreen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.besttodo.R
import com.example.besttodo.databinding.FragmentFireRootBinding
import com.example.besttodo.firebasescreen.adapters.ViewPageAdapter
import com.google.android.material.tabs.TabLayoutMediator


class FireRootFragment : Fragment() {
    private lateinit var binding: FragmentFireRootBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFireRootBinding.inflate(inflater, container , false)

        binding.vPage.adapter = ViewPageAdapter(context as FragmentActivity)
        binding.tvLay.tabIconTint = null


        TabLayoutMediator(binding.tvLay, binding.vPage){
                tab,pos ->
            when(pos){
                0 -> tab.setIcon(R.drawable.ic_baseline_edit_24)
                1 -> tab.setIcon(R.drawable.ic_baseline_done_all_24)
            }
        }.attach()


        return binding.root
    }

}