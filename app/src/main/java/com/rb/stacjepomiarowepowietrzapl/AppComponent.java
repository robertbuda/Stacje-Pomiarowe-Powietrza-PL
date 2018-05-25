package com.rb.stacjepomiarowepowietrzapl;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject (AllStationsActivity allStationsActivity);

}
