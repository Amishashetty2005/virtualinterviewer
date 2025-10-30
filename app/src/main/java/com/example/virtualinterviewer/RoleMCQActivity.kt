package com.example.virtualinterviewer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virtualinterviewer.data.MCQQuestion
import com.example.virtualinterviewer.databinding.ActivityRoleMcqBinding

class RoleMCQActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoleMcqBinding
    private lateinit var role: String    // ✅ Added this line
    private lateinit var roleQuestions: ArrayList<MCQQuestion>
    private lateinit var aptitudeQuestions: ArrayList<MCQQuestion>
    private lateinit var aptitudeSelections: HashMap<Int, String>
    private lateinit var introQuestions: ArrayList<com.example.virtualinterviewer.data.LongQuestion>
    private lateinit var introAnswers: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoleMcqBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.headerTitle.text = "Role MCQ"
        binding.headerSubtitle.text = "Answer role-specific questions"

        // ✅ Receive role from previous activity
        role = intent.getStringExtra("role") ?: "Android Developer"

        @Suppress("DEPRECATION")
        roleQuestions = intent.getSerializableExtra("role_questions") as? ArrayList<MCQQuestion> ?: arrayListOf()

        @Suppress("DEPRECATION")
        aptitudeQuestions = intent.getSerializableExtra("aptitude_questions") as? ArrayList<MCQQuestion> ?: arrayListOf()

        @Suppress("DEPRECATION")
        aptitudeSelections = intent.getSerializableExtra("aptitude_selections") as? HashMap<Int, String> ?: hashMapOf()

        @Suppress("DEPRECATION")
        introQuestions = intent.getSerializableExtra("intro_questions") as? ArrayList<com.example.virtualinterviewer.data.LongQuestion> ?: arrayListOf()

        @Suppress("DEPRECATION")
        introAnswers = intent.getSerializableExtra("intro_answers") as? ArrayList<String> ?: arrayListOf()

        val adapter = MCQAdapter(roleQuestions)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.btnNext.setOnClickListener {
            val roleSelections = adapter.getSelections()
            val currentRole = intent.getStringExtra("role") // ✅ fetch the role
            android.util.Log.d("DEBUG_ROLE", "Passing role to LongAnswerActivity: $currentRole")

            val i = Intent(this, LongAnswerActivity::class.java)
            i.putExtra("role", currentRole) // ✅ pass it along
            i.putExtra("role_questions", roleQuestions)
            i.putExtra("role_selections", HashMap(roleSelections))
            i.putExtra("aptitude_questions", aptitudeQuestions)
            i.putExtra("aptitude_selections", aptitudeSelections)
            i.putExtra("intro_questions", introQuestions)
            i.putExtra("intro_answers", introAnswers)
            startActivity(i)
        }

    }
}
