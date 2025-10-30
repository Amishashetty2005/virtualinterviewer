package com.example.virtualinterviewer.data

import java.io.Serializable

data class MCQQuestion(
    val question: String,
    val options: List<String>,
    val correctAnswer: String
) : Serializable
