package com.aruana.hireme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            composeEmail()
        }

        bottomNavigationView.setupWithNavController(navController = navigationHostFragment.findNavController())
    }

    private fun composeEmail() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            data = Uri.parse("mailto:")
            type = "*/*"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("a.kaique@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, "I want to hire you")
        }

        startActivity(intent)
    }
}
