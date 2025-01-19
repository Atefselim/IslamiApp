package com.example.islamiapp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityHomeBinding
import com.example.islamiapp.fragment.HadithFragment
import com.example.islamiapp.fragment.QuranFragment
import com.example.islamiapp.fragment.RadioFragment
import com.example.islamiapp.fragment.TasbeehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.islamicBottomNavView.setOnItemSelectedListener {menuItem->
            if (menuItem.itemId == R.id.navigation_quran){
                showFragment(QuranFragment())
            }
            else if(menuItem.itemId == R.id.navigation_hadith){
                showFragment(HadithFragment())
            }
            else if(menuItem.itemId == R.id.navigation_tasbeeh){
                showFragment(TasbeehFragment())
            }
            else if(menuItem.itemId == R.id.navigation_radio){
                showFragment(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }
        binding.islamicBottomNavView.selectedItemId = R.id.navigation_quran

    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.islamic_fragment_container,fragment)
            .commit()
    }
}