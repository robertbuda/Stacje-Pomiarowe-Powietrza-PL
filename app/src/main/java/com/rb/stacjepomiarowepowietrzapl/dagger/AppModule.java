package com.rb.stacjepomiarowepowietrzapl.dagger;

import android.app.Application;

import com.google.gson.Gson;
import com.rb.stacjepomiarowepowietrzapl.Api;
import com.rb.stacjepomiarowepowietrzapl.Commune;
import com.rb.stacjepomiarowepowietrzapl.StationContract;
import com.rb.stacjepomiarowepowietrzapl.StationPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    Application mApplication;
    StationContract.View view;
    Api api;

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


    @Provides
    @Singleton
    Retrofit provideRetrofit(){

        RxJava2CallAdapterFactory rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();
    }

    @Provides
    @Singleton
    Api provideApi() {
        return api;
    }


    @Provides
    @Singleton
    StationPresenter provideStationPresenter(StationContract.View view , Retrofit retrofit) {
        return new StationPresenter(view, retrofit.create(Api.class));
    }
}
