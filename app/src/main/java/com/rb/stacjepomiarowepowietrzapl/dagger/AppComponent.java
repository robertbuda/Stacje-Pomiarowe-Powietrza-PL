package com.rb.stacjepomiarowepowietrzapl.dagger;

import com.rb.stacjepomiarowepowietrzapl.AllStationsActivity;
import com.rb.stacjepomiarowepowietrzapl.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(AllStationsActivity allStationsActivity);

}
