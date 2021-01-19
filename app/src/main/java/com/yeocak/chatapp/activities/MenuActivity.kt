package com.yeocak.chatapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.yeocak.chatapp.MyFirebaseMessagingService.Companion.token
import com.yeocak.chatapp.R
import com.yeocak.chatapp.databinding.ActivityMenuBinding
import com.yeocak.chatapp.fragments.CommunityFragment
import com.yeocak.chatapp.fragments.MessagesFragment
import com.yeocak.chatapp.fragments.ProfileFragment
import com.yeocak.chatapp.fragments.SettingsFragment

class MenuActivity : AppCompatActivity() {

    lateinit var binding: ActivityMenuBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        supportFragmentManager.beginTransaction().replace(R.id.frMain, MessagesFragment()).commit()

        binding.bottomNavigation.setOnNavigationItemSelectedListener {

            val transaction = supportFragmentManager.beginTransaction()

            when (it.itemId) {
                R.id.ic_messages -> {
                    transaction.replace(R.id.frMain, MessagesFragment()).commit()
                    true
                }
                R.id.ic_community -> {
                    transaction.replace(R.id.frMain, CommunityFragment()).commit()
                    true
                }
                R.id.ic_profile -> {
                    transaction.replace(R.id.frMain, ProfileFragment()).commit()
                    true
                }
                R.id.ic_settings -> {
                    transaction.replace(R.id.frMain, SettingsFragment()).commit()
                    true
                }
                else -> false
            }
        }

    }

}