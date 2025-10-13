package com.example.virtualinterviewer

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnSave: Button
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var currentUserEmail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        btnSave = findViewById(R.id.btnSave)

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        currentUserEmail = intent.getStringExtra("email") ?: ""

        // Load saved info
        etName.setText(sharedPreferences.getString("${currentUserEmail}_name", ""))
        etEmail.setText(sharedPreferences.getString("${currentUserEmail}_email", ""))

        btnSave.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("${currentUserEmail}_name", etName.text.toString())
            editor.putString("${currentUserEmail}_email", etEmail.text.toString())
            editor.apply()
            finish() // go back to HomeActivity
        }
    }
}
