package com.example.gayus_3tic.Home.pertemuan11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gayus_3tic.R
import com.example.gayus_3tic.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 11"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.outline_arrow_left_alt_24)
        }
        binding.toolbar.setNavigationOnClickListener { finish() }

        // Setup ViewPager2 Adapter
        val adapter = TenthTabsAdapter(this)
        binding.viewPager.adapter = adapter

        // Hubungkan TabLayout dan ViewPager2 serta kustomisasi Ikon & Badge
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Tab A"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.outline_add_home_24)

                    // Badge berupa titik tanpa angka pada Tab A
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }
                1 -> {
                    tab.text = "Tab B"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.outline_business_messages_24)

                    // Badge dengan angka 5 pada Tab B
                    val badge = tab.getOrCreateBadge()
                    badge.number = 5
                    badge.isVisible = true
                }
                2 -> {
                    tab.text = "Produk"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.outline_more_horiz_24)
                }
            }
        }.attach()
    }
}
