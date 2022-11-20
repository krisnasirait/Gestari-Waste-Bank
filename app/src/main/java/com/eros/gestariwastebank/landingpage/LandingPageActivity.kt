package com.eros.gestariwastebank.landingpage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.eros.gestariwastebank.auth.LoginActivity
import com.eros.gestariwastebank.databinding.ActivityLandingPageBinding
import com.eros.gestariwastebank.landingpage.adapter.ViewPagerAdapter
import com.eros.gestariwastebank.landingpage.fragmentlanding.FirstLandingFragment
import com.eros.gestariwastebank.landingpage.fragmentlanding.SecondLandingFragment
import com.eros.gestariwastebank.landingpage.fragmentlanding.ThirdLandingFragment

class LandingPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Shared preference 1 time landing page
        val sharedPreferences = getSharedPreferences("prefGWA", 0)
        val isFirstTime = sharedPreferences.getString("isFirst", "")

        if(!isFirstTime.isNullOrEmpty()) {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        setFragment()
    }

    private fun setFragment() {
        val fragment: ArrayList<Fragment> = arrayListOf(
            FirstLandingFragment(),
            SecondLandingFragment(),
            ThirdLandingFragment()
        )
        ViewPagerAdapter(fragment, this).also {
            binding.vpLandingPage.adapter = it
        }
        binding.circleIndicator.setViewPager(binding.vpLandingPage)
    }
}