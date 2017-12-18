package com.kotlinsg.kworkshopapp

import android.content.Context
import com.kotlinsg.kworkshopapp.di.ApplicationContextProvider
import com.kotlinsg.kworkshopapp.di.NotificaitonProvider
import com.kotlinsg.kworkshopapp.di.RepoProvider


interface App {
    fun getApplicationContext(): Context
    fun getAppComponent(): ApplicationContextProvider
    fun getRepoComponent(): RepoProvider
    fun getNotificationComponent(): NotificaitonProvider
}