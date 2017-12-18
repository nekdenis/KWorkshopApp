package com.kotlinsg.kworkshopapp.di;

import com.kotlinsg.kworkshopapp.github.GithubUseCase;
import com.kotlinsg.kworkshopapp.github.GithubUseCaseImpl;

import dagger.Binds;
import dagger.Module;

@Module
public interface GithubActivityModule {
    @ActivityScope
    @Binds
    GithubUseCase bindsUseCase(GithubUseCaseImpl impl);
}