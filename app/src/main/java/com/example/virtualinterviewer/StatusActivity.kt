package com.example.virtualinterviewer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class StatusActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ScoreAdapter
    private var scoreList = mutableListOf<ScoreModel>()

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)

        recyclerView = findViewById(R.id.recyclerHistory)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ScoreAdapter(scoreList)
        recyclerView.adapter = adapter

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        loadScores()
    }

    private fun loadScores() {
        val user = mAuth.currentUser ?: return

        db.collection("users")
            .document(user.uid)
            .collection("interview_history")
            .orderBy("timestamp")
            .get()
            .addOnSuccessListener { result ->
                scoreList.clear()
                for (doc in result) {
                    val score = doc.getDouble("score") ?: 0.0
                    val interviewName = doc.getString("interviewName") ?: "Interview"
                    val timestamp = doc.getLong("timestamp") ?: System.currentTimeMillis()
                    scoreList.add(ScoreModel(interviewName, score, timestamp))
                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error loading history", Toast.LENGTH_SHORT).show()
            }
    }
}
