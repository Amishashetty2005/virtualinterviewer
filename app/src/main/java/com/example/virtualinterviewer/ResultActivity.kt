package com.example.virtualinterviewer

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.virtualinterviewer.data.LongQuestion
import com.example.virtualinterviewer.data.MCQQuestion
import com.example.virtualinterviewer.databinding.ActivityResultBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Firebase
        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        // Get data from intent
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
        val interviewName = intent.getStringExtra("interview_name") ?: "Interview"

        // Calculate scores
        val aptScore = scoreMCQ(aptitudeQuestions, aptitudeSelections)
        val roleScore = scoreMCQ(roleQuestions, roleSelections)
        val introScore = scoreLongByKeywords(introQuestions, introAnswers)
        val longScore = scoreLongByKeywords(longQuestions, longAnswers)

        val introOutOf5 = introScore.coerceAtMost(5.0)
        val longOutOf4 = longScore.coerceAtMost(4.0)

        val totalScore = (aptScore / 5.0 * 25.0) +
                (roleScore / 5.0 * 25.0) +
                (introOutOf5 / 5.0 * 25.0) +
                (longOutOf4 / 4.0 * 25.0)

        // Update UI
        binding.tvScore.text = "${"%.1f".format(totalScore)} / 100"
        binding.tvScore.typeface = Typeface.DEFAULT_BOLD
        binding.tvApt.text = "Aptitude: $aptScore / 5"
        binding.tvRole.text = "Role MCQ: $roleScore / 5"
        binding.tvIntro.text = "Intro: ${"%.1f".format(introOutOf5)} / 5"
        binding.tvLong.text = "Long answers: ${"%.1f".format(longOutOf4)} / 4"

        // Motivational message
        binding.tvMessage.text = if (totalScore >= 50) {
            "🎉 Congratulations! You passed this interview."
        } else {
            "💪 Keep trying! You can do better next time."
        }

        // Save result in Firestore
        saveScoreToFirestore(interviewName, totalScore)

        // Go to Home button
        binding.btnHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun scoreMCQ(questions: List<MCQQuestion>, selections: Map<Int, String>): Int {
        var score = 0
        for ((index, q) in questions.withIndex()) {
            val selected = selections[index]
            if (selected != null && selected == q.correctAnswer) {
                score++
            }
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

    private fun saveScoreToFirestore(interviewName: String, totalScore: Double) {
        val user = mAuth.currentUser ?: return

        val data = hashMapOf(
            "interviewName" to interviewName,
            "score" to totalScore,
            "timestamp" to System.currentTimeMillis()
        )

        db.collection("users")
            .document(user.uid)
            .collection("interview_history")
            .add(data)
    }
}
