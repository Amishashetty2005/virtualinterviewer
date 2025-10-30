package com.example.virtualinterviewer

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle

    // Drawer header views
    private lateinit var tvDrawerName: TextView
    private lateinit var tvDrawerEmail: TextView
    private lateinit var ivEditProfile: ImageView

    private lateinit var btnStartInterview: Button

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var currentUserEmail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) // Keep your home XML

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.navigation_view)
        btnStartInterview = findViewById(R.id.btn_start_interview)

        // SharedPreferences
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Get logged-in email from intent
        currentUserEmail = intent.getStringExtra("email") ?: ""

        // Setup drawer toggle
        toggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Header views
        val header = navView.getHeaderView(0)
        tvDrawerName = header.findViewById(R.id.tvDrawerName)
        tvDrawerEmail = header.findViewById(R.id.tvDrawerEmail)
        ivEditProfile = header.findViewById(R.id.ivEditProfile)

        loadUserProfile()

        // Open Edit Profile Activity
        ivEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra("email", currentUserEmail)
            startActivity(intent)
        }

        // Drawer menu item clicks
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_interview -> {
                    val intent = Intent(this, InterviewActivity::class.java)
                    intent.putExtra("email", currentUserEmail)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_status -> { /* handle status */ true }
                R.id.nav_settings -> { /* handle settings */ true }
                R.id.nav_logout -> {
                    finish() // logout
                    true
                }
                else -> false
            }
        }

        // Start Interview Button
        btnStartInterview.setOnClickListener {
            // start interview activity
            val intent = Intent(this, InterviewActivity::class.java)
            intent.putExtra("email", currentUserEmail)
            startActivity(intent)
        }
    }

    private fun loadUserProfile() {
        val name = sharedPreferences.getString("${currentUserEmail}_name", "")
        val email = sharedPreferences.getString("${currentUserEmail}_email", currentUserEmail)

        tvDrawerName.text = name ?: ""
        tvDrawerEmail.text = email ?: ""
    }

    override fun onResume() {
        super.onResume()
        loadUserProfile()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }
}
