package com.example.besttodo.todoscreen.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.besttodo.todoscreen.fragments.CompletedFragment
import com.example.besttodo.todoscreen.fragments.ListFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ListFragment()
            else -> CompletedFragment()
        }

    }

}