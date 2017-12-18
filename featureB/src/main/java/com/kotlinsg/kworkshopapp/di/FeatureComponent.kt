package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.MainBActivity
import dagger.Component

//@Singleton
//@Component(
//        dependencies = [RepoProvider::class],
////        modules = [FeatureModule::class])
//interface FeatureComponent {
//    fun inject(target: MainActivity)
//    fun inject(target: GithubActivity)
//}



@ActivityScope
@Component(
        dependencies = arrayOf(ApplicationContextProvider::class),
        modules = arrayOf(MainActivityBModule::class))
interface MainActivityBComponent {
    fun inject(activity: MainBActivity)

    class Initializer private constructor() {
        companion object {
            fun init(appComponent: ApplicationContextProvider): MainActivityBComponent =
                    DaggerMainActivityBComponent.builder()
                            .applicationContextProvider(appComponent).build()
        }
    }
}

