package com.example.besttodo.firebasescreen.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.besttodo.firebasescreen.fragments.CommentFragment
import com.example.besttodo.firebasescreen.fragments.FireBaseFragment


class ViewPageAdapter(fragmentActivity: FragmentActivity):  FragmentStateAdapter(fragmentActivity){

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FireBaseFragment()
            else -> CommentFragment()
        }

    }
}