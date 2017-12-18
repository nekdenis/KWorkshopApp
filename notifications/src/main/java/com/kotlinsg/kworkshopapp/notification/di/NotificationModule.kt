package com.kotlinsg.kworkshopapp.repo.di

import com.kotlinsg.kworkshopapp.notification.di.NotificationUseCase
import com.kotlinsg.kworkshopapp.notification.di.NotificationUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface NotificationModule {

    @Binds fun bindsNotificationUseCase(impl: NotificationUseCaseImpl): NotificationUseCase

}