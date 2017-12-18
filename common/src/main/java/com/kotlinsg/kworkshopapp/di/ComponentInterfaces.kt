package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.App
import com.kotlinsg.kworkshopapp.GithubProject
import com.kotlinsg.kworkshopapp.actions.ShowGithubScreenAction
import com.kotlinsg.kworkshopapp.notification.di.NotificationUseCase
import com.kotlinsg.kworkshopapp.repo.GithubRepo
import com.kotlinsg.kworkshopapp.tools.Toaster

interface ApplicationContextProvider : ActionsProvider {
    fun provideContext(): App
    fun provideLogger(): Logger
    fun provideToast(): Toaster
}

interface ActionsProvider {
    fun provideShowGithubScreenAction(): ShowGithubScreenAction
}

interface NetworkClientProvider {
    fun provideNetworkClient(): NetworkClient
}

interface RepoProvider : NetworkClientProvider {
    fun provideGithubRepo(): GithubRepo
}

interface NotificaitonProvider {
    fun provideNotificationUseCase(): NotificationUseCase
}

interface NetworkClient {
    fun requestProject(path: String, onResult: (GithubProject) -> Unit, onError: (Throwable) -> Unit)
}