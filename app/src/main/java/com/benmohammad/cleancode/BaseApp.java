package com.benmohammad.cleancode;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.benmohammad.cleancode.deps.DaggerDeps;
import com.benmohammad.cleancode.deps.Deps;
import com.benmohammad.cleancode.networking.NetworkModule;

import java.io.File;

public class BaseApp extends AppCompatActivity {

    Deps deps;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");

        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();
    }

    public Deps getDeps() {
        return deps;
    }


}
