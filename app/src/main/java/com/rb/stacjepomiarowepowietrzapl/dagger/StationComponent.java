package com.rb.stacjepomiarowepowietrzapl.dagger;

import com.rb.stacjepomiarowepowietrzapl.AllStationsActivity;
import com.rb.stacjepomiarowepowietrzapl.StationModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

@Singleton
@Component(modules = {CommuneModule.class})
public interface StationComponent {

    void inject (AllStationsActivity allStationsActivity);
}
