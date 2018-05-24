package com.rb.stacjepomiarowepowietrzapl.dagger;

import android.app.Application;

import com.rb.stacjepomiarowepowietrzapl.Commune;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Commune provideCommune() {
        return new Commune("asd", "dsa", "weq");
    }
}
