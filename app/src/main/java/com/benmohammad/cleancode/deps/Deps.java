package com.benmohammad.cleancode.deps;

import com.benmohammad.cleancode.home.HomeActivity;
import com.benmohammad.cleancode.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {

    void inject(HomeActivity homeActivity);
}
