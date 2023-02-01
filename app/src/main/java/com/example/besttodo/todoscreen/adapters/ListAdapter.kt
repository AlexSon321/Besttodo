package com.example.besttodo.todoscreen.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.besttodo.R
import com.example.besttodo.databinding.TodoItemBinding
import com.example.besttodo.todoscreen.fragments.RootFragmentDirections
import com.example.besttodo.todoscreen.model.TodoItem

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var todoList = emptyList<TodoItem>()

    class ListViewHolder(item: View): RecyclerView.ViewHolder(item){
        private var binding = TodoItemBinding.bind(item)
        fun bind(todoItem: TodoItem) = with(binding){
            idText.text = todoItem.id.toString()
            nameText.text = todoItem.nameTodo
            descText.text = todoItem.descTodo
            itemView.setOnClickListener {
                val action = RootFragmentDirections.actionRootFragmentToClickerSheetFragment(todoItem)
                itemView.findNavController().navigate(action)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return ListViewHolder(item)
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount(): Int {
        return todoList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addElem(todoItem: List<TodoItem>){
        todoList = todoItem
        notifyDataSetChanged()
    }

}