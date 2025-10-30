package com.example.virtualinterviewer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virtualinterviewer.data.MCQQuestion
import com.example.virtualinterviewer.databinding.ActivityAptitudeMcqBinding

class AptitudeMCQActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAptitudeMcqBinding
    private lateinit var aptitudeQuestions: ArrayList<MCQQuestion>
    private lateinit var roleQuestions: ArrayList<MCQQuestion>
    private lateinit var introQuestions: ArrayList<com.example.virtualinterviewer.data.LongQuestion>
    private lateinit var introAnswers: ArrayList<String>
    private lateinit var role: String // ✅ Added role variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAptitudeMcqBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.headerTitle.text = "Aptitude"
        binding.headerSubtitle.text = "Answer 5 aptitude questions"

        // ✅ Receive role from previous activity
        role = intent.getStringExtra("role") ?: "Android Developer"

        @Suppress("DEPRECATION")
        aptitudeQuestions = intent.getSerializableExtra("aptitude_questions") as? ArrayList<MCQQuestion>
            ?: arrayListOf()

        @Suppress("DEPRECATION")
        roleQuestions = intent.getSerializableExtra("role_questions") as? ArrayList<MCQQuestion>
            ?: arrayListOf()

        @Suppress("DEPRECATION")
        introQuestions = intent.getSerializableExtra("intro_questions") as? ArrayList<com.example.virtualinterviewer.data.LongQuestion>
            ?: arrayListOf()

        @Suppress("DEPRECATION")
        introAnswers = intent.getSerializableExtra("intro_answers") as? ArrayList<String>
            ?: arrayListOf()

        val adapter = MCQAdapter(aptitudeQuestions)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.btnNext.setOnClickListener {
            val selections = adapter.getSelections()
            val i = Intent(this, RoleMCQActivity::class.java)
            i.putExtra("role", role) // ✅ Pass the role along
            i.putExtra("role_questions", roleQuestions)
            i.putExtra("aptitude_questions", aptitudeQuestions)
            i.putExtra("aptitude_selections", HashMap(selections))
            i.putExtra("intro_questions", introQuestions)
            i.putExtra("intro_answers", introAnswers)
            startActivity(i)
        }
    }
}
