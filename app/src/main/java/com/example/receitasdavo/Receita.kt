package com.example.receitasdavo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Receita(
    val titulo: String,
    val tempo: String,
    val resIdimagem: Int,
    val ingredientes: List<String>
): Parcelable
