package com.example.islamiapp.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {
    lateinit var binding: FragmentTasbeehBinding
    private var count = 0
    var rotationAngle = 0f
    private var zekrArray = arrayOf(
        "سُبْحَانَ اللَّهِ",
        "الْحَمْدُ لِلَّهِ",
        "لَا إِلَهَ إِلَّا اللَّهُ",
        "اللَّهُ أَكْبَرُ")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(inflater,container,false)

        binding.zekrNameTv.text = zekrArray[0]

        binding.sebhaBodyImg.setOnClickListener {
            count++
            if (count > 33){
                count = 1
                val currentIndex = zekrArray.indexOf(binding.zekrNameTv.text.toString())
                val nextIndex = (currentIndex+1) % zekrArray.size
                binding.zekrNameTv.text = zekrArray[nextIndex].toString()
            }
            binding.zekrCountTv.text = count.toString()
            rotationAngle += 20f
            ObjectAnimator.ofFloat(binding.sebhaBodyImg, "rotation", rotationAngle).apply {
                duration = 300
                start()
            }
        }
        return binding.root
    }
}