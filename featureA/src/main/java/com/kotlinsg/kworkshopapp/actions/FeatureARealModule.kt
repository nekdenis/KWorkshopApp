package com.kotlinsg.kworkshopapp.actions;

import dagger.Module;
import dagger.Provides;

@Module
class FeatureARealModule {
    @Provides
    fun provideShowGithubAction(): ShowGithubScreenAction = ShowGithubScreenActionRealImpl()
}