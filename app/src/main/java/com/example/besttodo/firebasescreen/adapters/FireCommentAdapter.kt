package com.example.besttodo.firebasescreen.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.besttodo.R
import com.example.besttodo.databinding.CommentItemBinding
import com.example.besttodo.firebasescreen.model.FireBaseComment

class FireCommentAdapter: RecyclerView.Adapter<FireCommentAdapter.FireCommentViewHolder>() {

    private var commentList = emptyList<FireBaseComment>()


    class FireCommentViewHolder(item: View): RecyclerView.ViewHolder(item){
        private var binding = CommentItemBinding.bind(item)
        fun bind(fireBaseComment: FireBaseComment) = with(binding){
            ratingBar.rating = fireBaseComment.rateUser!!
            textView12.text = fireBaseComment.videoName
            tvCom.text = fireBaseComment.nameUser
            tvDesc.text = fireBaseComment.commentUser
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FireCommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent , false)
        return FireCommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: FireCommentViewHolder, position: Int) {
        holder.bind(commentList[position])
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addElem(fireBaseComment: List<FireBaseComment>){
        commentList = fireBaseComment
        notifyDataSetChanged()
    }







}