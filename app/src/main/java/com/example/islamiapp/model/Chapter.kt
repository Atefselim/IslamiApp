package com.example.islamiapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chapter
    (
    val order : String? =null,
    val titleAr : String? = null,
    val titleEn : String? = null,
    val length : String? = null
            ):Parcelable