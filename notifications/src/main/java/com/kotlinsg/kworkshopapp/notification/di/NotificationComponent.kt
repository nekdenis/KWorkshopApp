package com.kotlinsg.kworkshopapp.repo.di

import com.kotlinsg.kworkshopapp.di.ApplicationContextProvider
import com.kotlinsg.kworkshopapp.di.NotificaitonProvider
import dagger.Component

@Component(
        dependencies = [ApplicationContextProvider::class],
        modules = [NotificationModule::class])
interface NotificationComponent : NotificaitonProvider {
    class Initializer private constructor() {
        companion object {
            fun init(appComponent: ApplicationContextProvider): NotificationComponent = DaggerNotificationComponent.builder()
                    .applicationContextProvider(appComponent)
                    .build()
        }
    }
}