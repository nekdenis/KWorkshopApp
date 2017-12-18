package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.MainActivity
import dagger.Component

@ActivityScope
@Component(
        dependencies = arrayOf(ApplicationContextProvider::class),
        modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {
    fun inject(activity: MainActivity)

    class Initializer private constructor() {
        companion object {
            fun init(appComponent: ApplicationContextProvider): MainActivityComponent =
                    DaggerMainActivityComponent.builder()
                            .applicationContextProvider(appComponent).build()
        }
    }
}

