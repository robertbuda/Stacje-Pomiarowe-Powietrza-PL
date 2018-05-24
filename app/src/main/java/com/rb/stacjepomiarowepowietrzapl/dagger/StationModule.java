package com.rb.stacjepomiarowepowietrzapl.dagger;

import com.rb.stacjepomiarowepowietrzapl.Api;
import com.rb.stacjepomiarowepowietrzapl.StationContract;
import com.rb.stacjepomiarowepowietrzapl.StationPresenter;

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
