package com.example.virtualinterviewer

import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.virtualinterviewer.data.LongQuestion
import com.example.virtualinterviewer.data.MCQQuestion
import com.example.virtualinterviewer.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.headerTitle.text = "Results"
        binding.headerSubtitle.text = "Interview summary"

        @Suppress("DEPRECATION")
        val introQuestions = intent.getSerializableExtra("intro_questions") as? ArrayList<LongQuestion> ?: arrayListOf()
        @Suppress("DEPRECATION")
        val introAnswers = intent.getSerializableExtra("intro_answers") as? ArrayList<String> ?: arrayListOf()
        @Suppress("DEPRECATION")
        val aptitudeQuestions = intent.getSerializableExtra("aptitude_questions") as? ArrayList<MCQQuestion> ?: arrayListOf()
        @Suppress("DEPRECATION")
        val aptitudeSelections = intent.getSerializableExtra("aptitude_selections") as? HashMap<Int, String> ?: hashMapOf()
        @Suppress("DEPRECATION")
        val roleQuestions = intent.getSerializableExtra("role_questions") as? ArrayList<MCQQuestion> ?: arrayListOf()
        @Suppress("DEPRECATION")
        val roleSelections = intent.getSerializableExtra("role_selections") as? HashMap<Int, String> ?: hashMapOf()
        @Suppress("DEPRECATION")
        val longQuestions = intent.getSerializableExtra("long_questions") as? ArrayList<LongQuestion> ?: arrayListOf()
        @Suppress("DEPRECATION")
        val longAnswers = intent.getSerializableExtra("long_answers") as? ArrayList<String> ?: arrayListOf()

        val aptScore = scoreMCQ(aptitudeQuestions, aptitudeSelections)
        val roleScore = scoreMCQ(roleQuestions, roleSelections)
        val introScoreSum = scoreLongByKeywords(introQuestions, introAnswers) // sum fractions
        val longScoreSum = scoreLongByKeywords(longQuestions, longAnswers)

        val introOutOf5 = introScoreSum.coerceAtMost(5.0)
        val longOutOf4 = longScoreSum.coerceAtMost(4.0)

        val total = (aptScore / 5.0 * 25.0) + (roleScore / 5.0 * 25.0) +
                (introOutOf5 / 5.0 * 25.0) + (longOutOf4 / 4.0 * 25.0)

        binding.tvScore.text = "${"%.1f".format(total)} / 100"
        binding.tvScore.typeface = Typeface.DEFAULT_BOLD
        binding.tvApt.text = "Aptitude: $aptScore / 5"
        binding.tvRole.text = "Role MCQ: $roleScore / 5"
        binding.tvIntro.text = "Intro: ${"%.1f".format(introOutOf5)} / 5"
        binding.tvLong.text = "Long answers: ${"%.1f".format(longOutOf4)} / 4"

        val sb = StringBuilder()
        sb.append("Introduction feedback:\n")
        sb.append(sectionFeedback(introQuestions, introAnswers))
        sb.append("\nLong-answer feedback:\n")
        sb.append(sectionFeedback(longQuestions, longAnswers))

        binding.tvFeedback.text = sb.toString()
    }

    private fun scoreMCQ(questions: List<MCQQuestion>, selections: Map<Int, String>): Int {
        var score = 0
        for ((idx, q) in questions.withIndex()) {
            val sel = selections[idx]
            if (sel != null && sel == q.correctAnswer) score++
        }
        return score
    }

    private fun scoreLongByKeywords(questions: List<LongQuestion>, answers: List<String>): Double {
        if (questions.isEmpty()) return 0.0
        var sum = 0.0
        for (i in questions.indices) {
            val q = questions[i]
            val ans = answers.getOrNull(i) ?: ""
            val matched = q.keywords.count { kw -> ans.contains(kw, ignoreCase = true) }
            val frac = if (q.keywords.isNotEmpty()) matched.toDouble() / q.keywords.size else 0.0
            sum += frac
        }
        return sum
    }

    private fun sectionFeedback(questions: List<LongQuestion>, answers: List<String>): String {
        val sb = StringBuilder()
        for (i in questions.indices) {
            val q = questions[i]
            val ans = answers.getOrNull(i) ?: ""
            val matched = q.keywords.filter { kw -> ans.contains(kw, ignoreCase = true) }
            sb.append("Q${i+1}: matched keywords: ${if (matched.isEmpty()) "none" else matched.joinToString(", ")}\n")
        }
        return sb.toString()
    }
}
