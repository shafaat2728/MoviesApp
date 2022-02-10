package com.digitify.moviesapp.common

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.text.Selection
import android.text.TextUtils
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.digitify.moviesapp.R
import com.google.android.material.textfield.TextInputEditText

object BindingUtils {


    @JvmStatic
    @BindingAdapter("textChangeListener")
    fun setEditTextBackgroundState(
        textInputEditText: TextInputEditText, nonUsedValue: String
    ) {
        textInputEditText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                textInputEditText.background =
                    ContextCompat.getDrawable(textInputEditText.context, R.drawable.bg_et_field)
                changeDrawableColor(textInputEditText, R.color.black)
            } else if (!hasFocus && textInputEditText.text.toString().trim().isNotEmpty()) {
                textInputEditText.background =
                    ContextCompat.getDrawable(textInputEditText.context, R.drawable.bg_et_field)

                changeDrawableColor(textInputEditText, R.color.black)
            } else {
                textInputEditText.background = ContextCompat.getDrawable(
                    textInputEditText.context,
                    R.drawable.bg_et_empty_field
                )
                changeDrawableColor(textInputEditText, R.color.color_text_hint)
            }
        }
        textInputEditText.doOnTextChanged { text, _, _, _ ->
            if (!TextUtils.isEmpty(text)) {
                textInputEditText.background =
                    ContextCompat.getDrawable(textInputEditText.context, R.drawable.bg_et_field)

                changeDrawableColor(textInputEditText, R.color.black)

            } else if (textInputEditText.hasFocus()) {
                textInputEditText.background =
                    ContextCompat.getDrawable(textInputEditText.context, R.drawable.bg_et_field)

                changeDrawableColor(textInputEditText, R.color.black)
            } else {
                textInputEditText.background = ContextCompat.getDrawable(
                    textInputEditText.context,
                    R.drawable.bg_et_empty_field
                )

                changeDrawableColor(textInputEditText, R.color.color_text_hint)
            }
        }
    }


    private fun changeDrawableColor(textInputEditText: TextInputEditText, colorText: Int) {
        for (drawable in textInputEditText.compoundDrawablesRelative) {
            if (drawable != null) {
                drawable.colorFilter =
                    PorterDuffColorFilter(
                        ContextCompat.getColor(
                            textInputEditText.context,
                            colorText
                        ), PorterDuff.Mode.SRC_IN
                    )
            }
        }
    }


    @BindingAdapter("imageUrl")
    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val fullImgPath = "${Constants.IMG_URL}$imgUrl"
            val imgUri = fullImgPath.toUri().buildUpon().scheme("https").build()
            Glide.with(imgView.context)
                .load(imgUri)
                .placeholder(R.drawable.bg_placeholder)
                .into(imgView)
        }
    }

}