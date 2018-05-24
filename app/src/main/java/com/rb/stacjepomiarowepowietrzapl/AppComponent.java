package com.rb.stacjepomiarowepowietrzapl;

import com.rb.stacjepomiarowepowietrzapl.dagger.DaggerStationComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);


}
