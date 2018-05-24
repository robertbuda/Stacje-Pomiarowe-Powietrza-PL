package com.rb.stacjepomiarowepowietrzapl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StationModule {

    private StationContract.View view;

    public StationModule(StationContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    StationContract.Presenter provideStationPresenter (StationContract.View view, Api api){
        return new StationPresenter(view,api);
    }
}
