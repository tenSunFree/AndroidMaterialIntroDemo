package com.home.androidmaterialintrodemo.registered.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide
import com.home.androidmaterialintrodemo.R
import com.home.androidmaterialintrodemo.main.MainActivity
import com.home.androidmaterialintrodemo.registered.presenter.RegisteredPresenter
import com.home.androidmaterialintrodemo.registered.view.fragment.AdvertisementFragment
import com.home.androidmaterialintrodemo.registered.view.fragment.RegisteredFragment
import com.home.androidmaterialintrodemo.registered.view.fragment.RegistrationSuccessFragment

class RegisteredIntroActivity : IntroActivity() {

    private val registeredPresenter = RegisteredPresenter()
    private val registeredFragment = RegisteredFragment(this)
    private val registrationSuccessFragment = RegistrationSuccessFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buttonBackFunction = BUTTON_BACK_FUNCTION_BACK // 使用後退按鈕行為
        addSlide()
        addListener()
    }

    private fun addSlide() {
        addSlide(
            FragmentSlide.Builder()
                .background(R.color.color_05D3FA)
                .backgroundDark(R.color.colorPrimaryDark)
                .canGoBackward(false)
                .fragment(AdvertisementFragment())
                .build()
        )
        addSlide(
            FragmentSlide.Builder()
                .background(R.color.color_FAFAFA)
                .backgroundDark(R.color.colorPrimaryDark)
                .fragment(registeredFragment)
                .build()
        )
        addSlide(
            FragmentSlide.Builder()
                .background(R.color.color_FAFAFA)
                .backgroundDark(R.color.colorPrimaryDark)
                .fragment(registrationSuccessFragment)
                .build()
        )
    }

    private fun addListener() {
        addOnNavigationBlockedListener { position, _ ->
            if (position == 1) registeredFragment.inputFieldCannotBlank()
        }
        val endPosition = 2
        var currentPosition = 0
        val intent = Intent(this, MainActivity::class.java)
        addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (endPosition == position && currentPosition == position) {

                    startActivity(intent)
                } else currentPosition = position
            }
        })
    }

    fun setRegisteredBeanAndShowEmail(email: String, password: String, name: String) {
        registeredPresenter.setRegisteredBean(email, password, name)
        registrationSuccessFragment.showEmail(email)
    }

    /**
     * 不希望用戶退出簡介屏幕並最終處於未初始化狀態
     */
    override fun onBackPressed() {}
}