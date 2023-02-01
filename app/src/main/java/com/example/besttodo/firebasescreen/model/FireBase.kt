package com.example.besttodo.firebasescreen.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FireBase(
    val empId: String? = null,
    val empName: String? = null,
    val empSurname: String? = null,
    val empImg: String? = null,
    val empVideoUrl: String? = null
): Parcelable