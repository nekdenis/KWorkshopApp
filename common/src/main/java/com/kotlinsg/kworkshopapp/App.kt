package com.kotlinsg.kworkshopapp

import android.app.Activity
import android.content.Context
import com.kotlinsg.kworkshopapp.di.ApplicationContextProvider


interface App {
    fun inject(activity: Activity)
    fun getApplicationContext(): Context
    fun getAppComponent(): ApplicationContextProvider
}