package com.example.islamiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.databinding.ItemVerseBinding

class VerseAdapter(val verses :List<String>) :Adapter<VerseAdapter.VerseViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVerseBinding.inflate(inflater,parent,false)
        return VerseViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return verses.size
    }

    override fun onBindViewHolder(holder: VerseViewHolder, position: Int) {
        val verse = verses[position]
        holder.bind(verse,position)
    }

    class VerseViewHolder(val binding: ItemVerseBinding) :ViewHolder(binding.root) {
        fun bind(verse : String , position : Int){
            binding.verseTv.text = "[ ${position + 1} ] $verse"

        }

    }


}