package com.home.androidmaterialintrodemo.registered.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import com.heinrichreimersoftware.materialintro.app.SlideFragment
import com.home.androidmaterialintrodemo.R
import com.home.androidmaterialintrodemo.registered.view.activity.RegisteredIntroActivity
import kotlinx.android.synthetic.main.fragment_registered.*
import org.jetbrains.anko.support.v4.toast

class RegisteredFragment(private val activity: RegisteredIntroActivity) : SlideFragment() {

    override fun onCreateView(
        @NonNull inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registered, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_registered.setOnClickListener { nextSlide() }
        text_view_description.text = generateDescriptionSpannableStringBuilder()
        text_view_description.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun generateDescriptionSpannableStringBuilder(): SpannableStringBuilder {
        val descriptionString = "點擊註冊的同時，表示您同意飛比價格的\n隱私權政策 與 服務條款"
        return SpannableStringBuilder().also {
            it.append(descriptionString)
            it.setSpan(ForegroundColorSpan(Color.BLACK), 0, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            it.setSpan(
                ForegroundColorSpan(Color.rgb(0, 122, 189)),
                18,
                24,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            it.setSpan(object : ClickableSpan() {
                override fun onClick(widget: View) {
                    toast("隱私權政策")
                }

                override fun updateDrawState(ds: TextPaint) {
                    // 去除下劃線
                    ds.isUnderlineText = false
                }
            }, 18, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            it.setSpan(ForegroundColorSpan(Color.BLACK), 24, 26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            it.setSpan(
                ForegroundColorSpan(Color.rgb(0, 122, 189)),
                26,
                31,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            it.setSpan(object : ClickableSpan() {
                override fun onClick(widget: View) {
                    toast("服務條款")
                }

                override fun updateDrawState(ds: TextPaint) {
                    // 去除下劃線
                    ds.isUnderlineText = false
                }
            }, 26, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    override fun canGoForward(): Boolean {
        return if (text_input_edit_text_email.text!!.isNotEmpty() &&
            text_input_edit_text_password.text!!.isNotEmpty() &&
            text_input_edit_text_name.text!!.isNotEmpty()
        ) {
            activity.setRegisteredBeanAndShowEmail(
                text_input_edit_text_email.text.toString(),
                text_input_edit_text_password.text.toString(),
                text_input_edit_text_name.text.toString()
            )
            true
        } else false
    }

    fun inputFieldCannotBlank() {
        toast("輸入欄不能為空白！")
    }
}