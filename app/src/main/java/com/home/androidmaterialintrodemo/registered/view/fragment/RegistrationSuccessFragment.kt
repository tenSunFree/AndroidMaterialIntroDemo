package com.home.androidmaterialintrodemo.registered.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import com.heinrichreimersoftware.materialintro.app.SlideFragment
import com.home.androidmaterialintrodemo.R
import kotlinx.android.synthetic.main.fragment_registration_success.*

class RegistrationSuccessFragment : SlideFragment() {

    override fun onCreateView(
        @NonNull inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration_success, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        text_view_registered.setOnClickListener { nextSlide() }
    }

    fun showEmail(email: String) {
        text_view_email.text = email
    }
}