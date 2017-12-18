package com.kotlinsg.kworkshopapp

import android.app.Application
import com.kotlinsg.kworkshopapp.di.AppComponent
import com.kotlinsg.kworkshopapp.di.ApplicationContextProvider
import com.kotlinsg.kworkshopapp.di.NotificaitonProvider
import com.kotlinsg.kworkshopapp.di.RepoProvider
import com.kotlinsg.kworkshopapp.repo.di.NotificationComponent
import com.kotlinsg.kworkshopapp.repo.di.RepoComponent
import com.kotlinsg.kworkshopapp.tools.Toaster
import javax.inject.Inject


class RealApp : Application(), App {

    @Inject lateinit var toaster: Toaster
    val appComponent: AppComponent by lazy { AppComponent.Initializer.init(this@RealApp) }
    val repoComponent: RepoComponent by lazy { RepoComponent.Initializer.init(appComponent) }
    val notificationComponent: NotificationComponent by lazy { NotificationComponent.Initializer.init(appComponent) }


    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        toaster.show("app injected")
    }

    override fun getAppComponent(): ApplicationContextProvider = appComponent
    override fun getNotificationComponent(): NotificaitonProvider = notificationComponent
    override fun getRepoComponent(): RepoProvider = repoComponent
}