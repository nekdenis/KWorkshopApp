package com.kotlinsg.kworkshopapp

import android.app.Activity
import android.app.Application
import com.kotlinsg.kworkshopapp.di.AppComponent
import com.kotlinsg.kworkshopapp.di.GithubActivityComponent
import com.kotlinsg.kworkshopapp.di.MainActivityComponent
import com.kotlinsg.kworkshopapp.github.GithubActivity
import com.kotlinsg.kworkshopapp.repo.di.NotificationComponent
import com.kotlinsg.kworkshopapp.repo.di.RepoComponent


class RealApp : Application(), App {

    val appComponent: AppComponent by lazy { AppComponent.Initializer.init(this@RealApp) }
    val repoComponent: RepoComponent by lazy { RepoComponent.Initializer.init(appComponent) }
    val notificationComponent: NotificationComponent by lazy { NotificationComponent.Initializer.init(appComponent) }

    override fun inject(activity: Activity) {
        if (activity is MainActivity) MainActivityComponent.Initializer.init(appComponent).inject(activity)
        if (activity is GithubActivity) {
            GithubActivityComponent.Initializer.init(appComponent, repoComponent, notificationComponent).inject(activity)
        }
    }
}