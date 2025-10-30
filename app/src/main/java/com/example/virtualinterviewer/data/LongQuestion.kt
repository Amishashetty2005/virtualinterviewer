package com.example.virtualinterviewer.data

import java.io.Serializable

data class LongQuestion(
    val prompt: String,
    val keywords: List<String>
) : Serializable
