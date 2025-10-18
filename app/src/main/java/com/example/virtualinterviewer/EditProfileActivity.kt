package com.example.virtualinterviewer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class EditProfileActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnSave: Button

    private lateinit var currentUserEmail: String
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        mAuth = FirebaseAuth.getInstance()
        currentUserEmail = intent.getStringExtra("current_user_email") ?: mAuth.currentUser?.email ?: ""

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        btnSave = findViewById(R.id.btnSave)

        // Load current saved values for this user
        val prefs = getSharedPreferences("user_profiles", Context.MODE_PRIVATE)
        etName.setText(prefs.getString("${currentUserEmail}_name", ""))
        etEmail.setText(prefs.getString("${currentUserEmail}_email", ""))

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save values in SharedPreferences per user
            val editor = prefs.edit()
            editor.putString("${currentUserEmail}_name", name)
            editor.putString("${currentUserEmail}_email", email)
            editor.apply()

            Toast.makeText(this, "Profile Updated", Toast.LENGTH_SHORT).show()
            finish() // Go back to HomeActivity
        }
    }
}
