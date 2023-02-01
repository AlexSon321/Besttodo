package com.example.besttodo.todoscreen.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.besttodo.R
import com.example.besttodo.databinding.CompleteTodoBinding
import com.example.besttodo.todoscreen.model.CompleteTodo

class CompleteAdapter: RecyclerView.Adapter<CompleteAdapter.CompleteViewHolder>() {

    private var completeList = emptyList<CompleteTodo>()

    class CompleteViewHolder(item: View): RecyclerView.ViewHolder(item){
        private var binding = CompleteTodoBinding.bind(item)
        fun bind(completeTodo: CompleteTodo) = with(binding){
            idText.text = completeTodo.id.toString()
            nameText.text = completeTodo.nameTodo
            descText.text = completeTodo.descTodo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompleteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.complete_todo, parent, false)
        return CompleteViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompleteViewHolder, position: Int) {
        holder.bind(completeList[position])
    }

    override fun getItemCount(): Int {
        return completeList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addElem(completeTodo: List<CompleteTodo>){

        completeList = completeTodo
        notifyDataSetChanged()
    }

}