package com.example.islamiapp.chapterdetails

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islamiapp.R
import com.example.islamiapp.adapters.VerseAdapter
import com.example.islamiapp.databinding.ActivityChapterDetailsBinding
import com.example.islamiapp.model.AppConstants
import com.example.islamiapp.model.Chapter

class ChapterDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityChapterDetailsBinding
    lateinit var adapter: VerseAdapter
    var chapter : Chapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        receiveParams()
        initRecyclerView()
    }

    private fun initRecyclerView() {

        adapter = VerseAdapter(readChapterVerses())
        binding.versesRecyclerview.adapter = adapter
        binding.chapterTitleArTv.text = chapter?.titleAr
        binding.chapterTitleEnTv.text = chapter?.titleEn
        binding.icBackImg.setOnClickListener {
            finish()
        }
    }

    private fun readChapterVerses(): List<String> {
        val fileContent = assets.open("quran/${chapter?.order}.txt").bufferedReader()
            .use {
                it.readText()
            }
        return fileContent.trim().split("\n")
    }

    fun receiveParams(){
        chapter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
             intent.getParcelableExtra(AppConstants.CHAPTER_KEY,Chapter::class.java)
        }else  {
             intent.getParcelableExtra(AppConstants.CHAPTER_KEY)
        }
    }
}