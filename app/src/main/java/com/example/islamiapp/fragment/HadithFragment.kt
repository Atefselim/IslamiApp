package com.example.islamiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.R
import com.example.islamiapp.adapters.HadithAdapter
import com.example.islamiapp.databinding.FragmentHadithBinding
import com.example.islamiapp.model.Hadith
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.google.android.material.carousel.HeroCarouselStrategy


class HadithFragment : Fragment() {
   lateinit var binding: FragmentHadithBinding
   lateinit var layoutManager : CarouselLayoutManager
   lateinit var adapter: HadithAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadithBinding.inflate(inflater,container,false)
        return binding.root
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = CarouselLayoutManager(FullScreenCarouselStrategy(),CarouselLayoutManager.HORIZONTAL)
        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        binding.hadithRecyclerView.layoutManager = layoutManager
        val list = readHadithList()
        val carouselSnapHelper = CarouselSnapHelper()
        carouselSnapHelper.attachToRecyclerView(binding.hadithRecyclerView)
        adapter = HadithAdapter(list)
        binding.hadithRecyclerView.adapter = adapter
    }

    private fun readHadithList(): List<Hadith> {
        val hadithAsString = requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val hadithStringList = hadithAsString.trim().split("#")

        return hadithStringList.map {
            val singleHadithSplit = it.trim().split("\n")
            Hadith(hadithTitle = singleHadithSplit[0], hadithDescription = singleHadithSplit.subList(1,singleHadithSplit.size).joinToString())
        }


    }
}