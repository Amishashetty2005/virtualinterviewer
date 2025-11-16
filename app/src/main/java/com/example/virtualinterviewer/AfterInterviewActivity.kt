package com.example.virtualinterviewer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AfterInterviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_interview)

        val tvMessage = findViewById<TextView>(R.id.tvFinalMessage)
        val btnViewStatus = findViewById<Button>(R.id.btnViewStatus)

        val aptitudeScore = intent.getIntExtra("aptitudeScore", 0)
        val roleScore = intent.getIntExtra("roleScore", 0)
        val longAnswerScore = intent.getIntExtra("longAnswerScore", 0)
        val longAnswerFeedback = intent.getStringExtra("longAnswerFeedback") ?: "No feedback"
        val totalScore = intent.getIntExtra("totalScore", 0)

        tvMessage.text = "Your Interview Result Saved Successfully!"

        val manager = InterviewResultManager(this)
        manager.saveInterviewResult(
            aptitudeScore,
            roleScore,
            longAnswerScore,
            longAnswerFeedback,
            totalScore
        )

        btnViewStatus.setOnClickListener {
            val intent = Intent(this, StatusActivity::class.java)
            startActivity(intent)
        }
    }
}
