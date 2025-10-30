package com.example.virtualinterviewer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.virtualinterviewer.data.LongQuestion
import com.example.virtualinterviewer.data.QuestionRepository
import com.example.virtualinterviewer.databinding.ActivityLongAnswerBinding

class LongAnswerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLongAnswerBinding
    private lateinit var role: String
    private lateinit var longSelected: List<LongQuestion>
    private var idx = 0
    private val answers = mutableListOf<String>()

    private lateinit var introQuestions: ArrayList<LongQuestion>
    private lateinit var introAnswers: ArrayList<String>
    private lateinit var aptitudeQuestions: ArrayList<com.example.virtualinterviewer.data.MCQQuestion>
    private lateinit var aptitudeSelections: HashMap<Int, String>
    private lateinit var roleQuestions: ArrayList<com.example.virtualinterviewer.data.MCQQuestion>
    private lateinit var roleSelections: HashMap<Int, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLongAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.headerTitle.text = "Long Answers"
        binding.headerSubtitle.text = "Provide detailed answers"

        role = intent.getStringExtra("role") ?: "Android Developer"

        @Suppress("DEPRECATION")
        introQuestions = intent.getSerializableExtra("intro_questions") as? ArrayList<LongQuestion> ?: arrayListOf()

        @Suppress("DEPRECATION")
        introAnswers = intent.getSerializableExtra("intro_answers") as? ArrayList<String> ?: arrayListOf()

        @Suppress("DEPRECATION")
        aptitudeQuestions = intent.getSerializableExtra("aptitude_questions") as? ArrayList<com.example.virtualinterviewer.data.MCQQuestion> ?: arrayListOf()

        @Suppress("DEPRECATION")
        aptitudeSelections = intent.getSerializableExtra("aptitude_selections") as? HashMap<Int, String> ?: hashMapOf()

        @Suppress("DEPRECATION")
        roleQuestions = intent.getSerializableExtra("role_questions") as? ArrayList<com.example.virtualinterviewer.data.MCQQuestion> ?: arrayListOf()

        @Suppress("DEPRECATION")
        roleSelections = intent.getSerializableExtra("role_selections") as? HashMap<Int, String> ?: hashMapOf()

        longSelected = QuestionRepository.getRoleLongs(role).shuffled().take(4)

        showCurrent()

        binding.btnNext.setOnClickListener {
            val ans = binding.etLongAnswer.text.toString().trim()
            answers.add(ans)
            binding.etLongAnswer.setText("")
            idx++
            if (idx < longSelected.size) {
                showCurrent()
            } else {
                val i = Intent(this, ResultActivity::class.java)
                i.putExtra("intro_questions", introQuestions)
                i.putExtra("intro_answers", introAnswers)
                i.putExtra("aptitude_questions", aptitudeQuestions)
                i.putExtra("aptitude_selections", aptitudeSelections)
                i.putExtra("role_questions", roleQuestions)
                i.putExtra("role_selections", roleSelections)
                i.putExtra("long_questions", ArrayList(longSelected))
                i.putExtra("long_answers", ArrayList(answers))
                startActivity(i)
            }
        }
    }

    private fun showCurrent() {
        val q = longSelected[idx]
        binding.tvLongPrompt.text = "Q${idx + 1}/${longSelected.size}: ${q.prompt}"
    }
}
