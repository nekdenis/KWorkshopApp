package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.RealApp
import dagger.Component
import javax.inject.Singleton


@Component(
        modules = [
            AppModule::class, ToolsModule::class,
//                        FeatureARealModule::class
            FeatureAFakeModule::class
        ]
)
@Singleton
interface AppComponent : ApplicationContextProvider {

    fun inject(app: RealApp)

    class Initializer private constructor() {
        companion object {
            fun init(app: RealApp): AppComponent = DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
        }
    }
}

