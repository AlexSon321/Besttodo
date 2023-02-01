package com.example.besttodo.firebasescreen.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.besttodo.R
import com.example.besttodo.databinding.FireItemBinding

import com.example.besttodo.firebasescreen.fragments.FireRootFragmentDirections
import com.example.besttodo.firebasescreen.model.FireBase
import com.squareup.picasso.Picasso

class FireBaseAdapter(): RecyclerView.Adapter<FireBaseAdapter.FireBaseViewHolder>() {

    private var fireList = ArrayList<FireBase>()

    class FireBaseViewHolder(item: View): RecyclerView.ViewHolder(item){
        private var binding = FireItemBinding.bind(item)
        fun bind(fireBase: FireBase) = with(binding){
            tvName.text = fireBase.empName
            tvSur.text = fireBase.empSurname
            val imgUrl  = fireBase.empImg
            Picasso.get().load(imgUrl).into(imageView5)
            itemView.setOnClickListener{
                val action = FireRootFragmentDirections.actionFireRootFragmentToFireVideoFragment(fireBase)
                itemView.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FireBaseViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.fire_item, parent, false)
        return FireBaseViewHolder(item)
    }

    override fun onBindViewHolder(holder: FireBaseViewHolder, position: Int) {
        holder.bind(fireList[position])
    }

    override fun getItemCount(): Int {
        return fireList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addElem(fireBase: ArrayList<FireBase>){
        fireList = fireBase
        notifyDataSetChanged()
    }


}