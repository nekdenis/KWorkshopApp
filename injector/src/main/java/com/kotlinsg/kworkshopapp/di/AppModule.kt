package com.kotlinsg.kworkshopapp.di

import android.content.Context
import com.kotlinsg.kworkshopapp.App
import com.kotlinsg.kworkshopapp.RealApp
import com.kotlinsg.kworkshopapp.actions.ShowGithubScreenAction
import com.kotlinsg.kworkshopapp.tools.LoggerImpl
import com.kotlinsg.kworkshopapp.tools.Toaster
import com.kotlinsg.kworkshopapp.tools.ToasterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val app: RealApp) {

    @Provides
    @Singleton
    fun app(): App {
        return app
    }

    @Provides
    @Singleton
    fun context(): Context {
        return app.getApplicationContext()
    }
}

@Module class ToolsModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideLogger(): Logger {
            return LoggerImpl()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideToaster(appContext: Context): Toaster {
            return ToasterImpl(appContext)
        }
    }
}

@Module class FeatureAFakeModule {
    @Provides
    fun provideShowGithubAction(toaster: Toaster): ShowGithubScreenAction = object : ShowGithubScreenAction {
        override fun show(context: Context) {
            toaster.show("Github feature is not injected")
        }
    }
}