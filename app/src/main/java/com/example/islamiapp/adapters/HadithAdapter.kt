package com.example.islamiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.databinding.ItemHadithBinding
import com.example.islamiapp.model.Hadith

class HadithAdapter(val hadithList :List<Hadith>):Adapter<HadithAdapter.HadithViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadithViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHadithBinding.inflate(inflater,parent,false)
        return HadithViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hadithList.size
    }

    override fun onBindViewHolder(holder: HadithViewHolder, position: Int) {
        val item = hadithList[position]
        holder.bind(hadith = item)
    }
    class HadithViewHolder(val binding: ItemHadithBinding):ViewHolder(binding.root){
        fun bind(hadith:Hadith){
            binding.hadithTitleTv.text = hadith.hadithTitle
            binding.hadithDescriptionTv.text = hadith.hadithDescription
        }

    }


}