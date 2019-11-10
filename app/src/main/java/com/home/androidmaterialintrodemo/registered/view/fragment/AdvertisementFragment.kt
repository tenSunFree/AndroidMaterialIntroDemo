package com.home.androidmaterialintrodemo.registered.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import com.heinrichreimersoftware.materialintro.app.SlideFragment
import com.home.androidmaterialintrodemo.R

class AdvertisementFragment : SlideFragment() {

    override fun onCreateView(
        @NonNull inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_advertisement, container, false)
    }
}