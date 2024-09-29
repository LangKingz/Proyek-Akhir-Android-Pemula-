package com.example.sepatu

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sepatu (
    var name: String,
    var detail: String,
    var photo: Int
): Parcelable