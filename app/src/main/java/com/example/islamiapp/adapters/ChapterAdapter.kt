package com.example.islamiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.databinding.ItemChapterBinding
import com.example.islamiapp.model.Chapter

class ChapterAdapter(val chapters:List<Chapter>) :Adapter<ChapterAdapter.ChapterViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemChapterBinding.inflate(inflater,parent,false)
        return ChapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val item = chapters[position]
        holder.bind(item)
    }




    class ChapterViewHolder(val binding : ItemChapterBinding):ViewHolder(binding.root){
        fun bind(chapter:Chapter){
            binding.suraTitleArTv.text = "${chapter.titleAr}"
            binding.suraTitleEnTv.text = "${chapter.titleEn}"
            binding.numberOfVerses.text = "${chapter.length} Verses"
            binding.suraNumberTv.text = "${chapter.order}"
        }

    }


}