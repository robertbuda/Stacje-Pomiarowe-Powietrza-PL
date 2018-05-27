package com.rb.stacjepomiarowepowietrzapl;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject (AllStationsActivity allStationsActivity);

}
