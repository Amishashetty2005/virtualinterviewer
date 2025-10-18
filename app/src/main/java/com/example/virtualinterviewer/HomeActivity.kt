package com.example.virtualinterviewer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var btnStartInterview: Button

    // Profile info in drawer header
    private lateinit var tvDrawerName: TextView
    private lateinit var tvDrawerEmail: TextView
    private lateinit var ivEditProfile: ImageView

    private lateinit var currentUserEmail: String
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mAuth = FirebaseAuth.getInstance()
        currentUserEmail = mAuth.currentUser?.email ?: "" // Get logged-in user's email

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        btnStartInterview = findViewById(R.id.btn_start_interview)

        // Toolbar setup
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Get drawer header views
        val headerView = navigationView.getHeaderView(0)
        tvDrawerName = headerView.findViewById(R.id.tvProfileName)
        tvDrawerEmail = headerView.findViewById(R.id.tvProfileEmail)
        ivEditProfile = headerView.findViewById(R.id.editProfileIcon)

        // Load profile info for current user
        loadProfile()

        // Edit Profile click
        ivEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra("current_user_email", currentUserEmail)
            startActivity(intent)
        }

        // Start Interview button click
        btnStartInterview.setOnClickListener {
            // Handle start interview
        }

        // Logout menu item
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.nav_logout -> {
                    mAuth.signOut()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                else -> {}
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onResume() {
        super.onResume()
        loadProfile() // Update profile info after returning from EditProfileActivity
    }

    private fun loadProfile() {
        val prefs = getSharedPreferences("user_profiles", MODE_PRIVATE)
        tvDrawerName.text = prefs.getString("${currentUserEmail}_name", "")
        tvDrawerEmail.text = prefs.getString("${currentUserEmail}_email", "")
    }
}
