package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.github.GithubActivity
import dagger.Component

@ActivityScope
@Component(
        dependencies = arrayOf(ApplicationContextProvider::class, RepoProvider::class, NotificaitonProvider::class),
        modules = arrayOf(GithubActivityModule::class))
interface GithubActivityComponent {
    fun inject(activity: GithubActivity)

    class Initializer private constructor() {
        companion object {
            fun init(
                    applicationContextProvider: ApplicationContextProvider,
                    repoComponent: RepoProvider,
                    notificaitonComponent: NotificaitonProvider
            ): GithubActivityComponent =
                    DaggerGithubActivityComponent.builder()
                            .applicationContextProvider(applicationContextProvider)
                            .repoProvider(repoComponent)
                            .notificaitonProvider(notificaitonComponent)
                            .build()
        }
    }
}


