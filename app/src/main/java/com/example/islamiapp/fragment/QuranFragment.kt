package com.example.islamiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.R
import com.example.islamiapp.adapters.ChapterAdapter
import com.example.islamiapp.databinding.FragmentQuranBinding
import com.example.islamiapp.model.AppConstants


class QuranFragment : Fragment() {
   lateinit var binding: FragmentQuranBinding
   lateinit var adapter : ChapterAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ChapterAdapter(AppConstants.getChaptersList())
        binding.chapterRecyclerView.adapter = adapter
        
    }

}