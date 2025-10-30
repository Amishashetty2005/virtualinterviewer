package com.example.virtualinterviewer

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.virtualinterviewer.data.QuestionRepository
import com.example.virtualinterviewer.data.MCQQuestion
import com.example.virtualinterviewer.data.LongQuestion
import com.example.virtualinterviewer.databinding.ActivityInterviewBinding

class InterviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInterviewBinding
    private val roles = listOf(
        "Android Developer",
        "Web Developer",
        "Data Analyst",
        "AI Engineer",
        "Cybersecurity Specialist"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // header
        binding.headerTitle.text = "AI Virtual Interviewer"
        binding.headerSubtitle.text = "Choose a role to begin"

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, roles)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerRole.adapter = adapter

        binding.btnStart.setOnClickListener {
            val role = binding.spinnerRole.selectedItem as String

            val aptitude = QuestionRepository.aptitudeQuestions.shuffled().take(5)
            val roleMCQs = QuestionRepository.getRoleMCQs(role).shuffled().take(5)
            val intros = QuestionRepository.introPrompts.shuffled().take(5)

            val i = Intent(this, IntroductionActivity::class.java)
            i.putExtra("role", role)
            i.putExtra("aptitude_questions", ArrayList(aptitude))
            i.putExtra("role_questions", ArrayList(roleMCQs))
            i.putExtra("intro_questions", ArrayList(intros))
            startActivity(i)
        }
    }
}
