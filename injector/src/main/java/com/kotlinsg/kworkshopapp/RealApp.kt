package com.kotlinsg.kworkshopapp

import android.app.Activity
import android.app.Application
import com.kotlinsg.kworkshopapp.di.AppComponent
import com.kotlinsg.kworkshopapp.di.ApplicationContextProvider
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
    }

    override fun inject(activity: Activity) {
//        if (activity is MainActivity) MainActivityComponent.Initializer.init(appComponent).inject(activity)
//        if (activity is GithubActivity) {
//            GithubActivityComponent.Initializer.init(appComponent, repoComponent, notificationComponent).inject(activity)
//        }
    }

    override fun getAppComponent(): ApplicationContextProvider = appComponent
}