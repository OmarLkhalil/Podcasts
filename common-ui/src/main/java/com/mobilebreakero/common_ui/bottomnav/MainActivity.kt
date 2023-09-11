package com.mobilebreakero.common_ui.bottomnav

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.podcast.PodcastFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.mobilebreakero.common_ui.R
import com.mobilebreakero.home.screen.HomeFragment
import com.mobilebreakero.music.screen.FavoriteFragment
import com.mobilebreakero.search.screen.SearchFragment
import com.mobilebreakero.settings.screen.SettingFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView
    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.framentContinar, HomeFragment())
            .commit()

        bottomNav = findViewById(R.id.buttomNavigathion)

        bottomNav.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            if (item.itemId == R.id.home) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framentContinar, HomeFragment()).commit()
            } else if (item.itemId == R.id.search) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framentContinar, SearchFragment()).commit()
            } else if (item.itemId == R.id.favorite) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framentContinar, FavoriteFragment()).commit()
            } else if (item.itemId == R.id.podcast) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framentContinar, PodcastFragment()).commit()
            } else if (item.itemId == R.id.settings) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framentContinar, SettingFragment()).commit()
            }
            true
        })
    }
}