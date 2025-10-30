package com.example.virtualinterviewer

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.virtualinterviewer.data.LongQuestion
import com.example.virtualinterviewer.databinding.ActivityIntroductionBinding
import java.util.*

class IntroductionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroductionBinding
    private lateinit var role: String
    private lateinit var introQuestions: ArrayList<LongQuestion>
    private var idx = 0
    private val answers = mutableListOf<String>()
    private lateinit var aptitudeQuestions: ArrayList<com.example.virtualinterviewer.data.MCQQuestion>
    private lateinit var roleQuestions: ArrayList<com.example.virtualinterviewer.data.MCQQuestion>

    private val speechLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val matches = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            binding.etAnswer.setText(matches?.getOrNull(0) ?: "")
        } else {
            Toast.makeText(this, "Speech canceled or failed", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.headerTitle.text = "Introduction"
        role = intent.getStringExtra("role") ?: "Android Developer"
        binding.headerSubtitle.text = "Role: $role"

        @Suppress("DEPRECATION")
        introQuestions = intent.getSerializableExtra("intro_questions") as? ArrayList<LongQuestion> ?: arrayListOf()

        @Suppress("DEPRECATION")
        aptitudeQuestions = intent.getSerializableExtra("aptitude_questions") as? ArrayList<com.example.virtualinterviewer.data.MCQQuestion> ?: arrayListOf()

        @Suppress("DEPRECATION")
        roleQuestions = intent.getSerializableExtra("role_questions") as? ArrayList<com.example.virtualinterviewer.data.MCQQuestion> ?: arrayListOf()

        showCurrent()

        binding.btnRecord.setOnClickListener { startSpeech() }

        binding.btnNext.setOnClickListener {
            val text = binding.etAnswer.text.toString().trim()
            answers.add(text)
            binding.etAnswer.setText("")
            idx++
            if (idx < introQuestions.size) showCurrent()
            else {
                val i = Intent(this, AptitudeMCQActivity::class.java)
                i.putExtra("role", role)
                i.putExtra("intro_questions", introQuestions)
                i.putExtra("intro_answers", ArrayList(answers))
                i.putExtra("aptitude_questions", aptitudeQuestions)
                i.putExtra("role_questions", roleQuestions)
                startActivity(i)
            }
        }
    }

    private fun showCurrent() {
        val q = introQuestions[idx]
        binding.tvQuestion.text = "Q${idx+1}/${introQuestions.size}: ${q.prompt}"
    }

    private fun startSpeech() {
        val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak your answer")
        }
        speechLauncher.launch(i)
    }
}
