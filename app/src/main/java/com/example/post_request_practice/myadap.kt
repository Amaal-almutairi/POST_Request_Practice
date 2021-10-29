package com.example.post_request_practice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.post_request_practice.databinding.ItemRowBinding


class myadap(private var users : ArrayList<String>): RecyclerView.Adapter<myadap.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var user =users [position]


        holder.binding.apply {

            txtRv.text=user

        }
    }

    override fun getItemCount() = users.size





}

