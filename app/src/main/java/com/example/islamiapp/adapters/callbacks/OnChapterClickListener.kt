package com.example.islamiapp.adapters.callbacks

import com.example.islamiapp.model.Chapter

interface OnChapterClickListener {
    fun onChapterClick(chapter: Chapter , position: Int)
}