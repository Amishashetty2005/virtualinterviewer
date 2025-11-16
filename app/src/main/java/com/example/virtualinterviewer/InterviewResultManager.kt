package com.example.virtualinterviewer

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class InterviewResultManager(private val context: Context) {

    private val prefs = context.getSharedPreferences("interview_history", Context.MODE_PRIVATE)

    fun saveInterviewResult(
        aptitudeScore: Int,
        roleScore: Int,
        longAnswerScore: Int,
        longAnswerFeedback: String,
        totalScore: Int
    ) {
        val historyJson = prefs.getString("history", "[]")
        val historyArray = JSONArray(historyJson)

        val dateFormat = SimpleDateFormat("dd MMM yyyy • hh:mm a", Locale.getDefault())
        val currentDate = dateFormat.format(Date())

        val interviewObj = JSONObject()
        interviewObj.put("aptitudeScore", aptitudeScore)
        interviewObj.put("roleScore", roleScore)
        interviewObj.put("longAnswerScore", longAnswerScore)
        interviewObj.put("longAnswerFeedback", longAnswerFeedback)
        interviewObj.put("totalScore", totalScore)
        interviewObj.put("date", currentDate)

        // Add latest interview at top
        historyArray.put(0, interviewObj)

        prefs.edit().putString("history", historyArray.toString()).apply()
    }

    fun getInterviewHistory(): JSONArray {
        val historyJson = prefs.getString("history", "[]")
        return JSONArray(historyJson)
    }
}
