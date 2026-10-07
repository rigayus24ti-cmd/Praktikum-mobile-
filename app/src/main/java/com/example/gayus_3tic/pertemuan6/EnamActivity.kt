package com.example.gayus_3tic.pertemuan6

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.gayus_3tic.R
import com.example.gayus_3tic.databinding.ActivityEnamBinding

class EnamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEnamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Halaman Pertemuan 6"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.outline_arrow_left_alt_24)
        }

        // Setup event click untuk mengganti fragment bagian ATAS saja
        binding.btnfrag1.setOnClickListener { replaceTopFragment(SatuFragment()) }
        binding.btnfrag2.setOnClickListener { replaceTopFragment(DuaFragment()) }
        binding.btnfrag3.setOnClickListener { replaceTopFragment(TigaFragment()) }

        if (savedInstanceState == null) {
            // Pasang fragment atas (SatuFragment) dan fragment bawah (DuaFragment) secara default
            supportFragmentManager.beginTransaction()
                .replace(binding.containerFragmentTop.id, SatuFragment())
                .replace(binding.containerFragmentBottom.id, DuaFragment())
                .commit()
        }
    }

    private fun replaceTopFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.containerFragmentTop.id, fragment)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
