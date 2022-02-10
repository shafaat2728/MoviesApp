package com.digitify.moviesapp

import android.app.Application
import com.digitify.moviesapp.common.InternetUtil

import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class MyApplication : Application(){


    override fun onCreate() {
        super.onCreate()
        InternetUtil.init(this)

    }



}