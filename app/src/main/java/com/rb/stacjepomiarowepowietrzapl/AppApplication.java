package com.rb.stacjepomiarowepowietrzapl;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.rb.stacjepomiarowepowietrzapl.dagger.CommuneModule;
import com.rb.stacjepomiarowepowietrzapl.dagger.DaggerStationComponent;
import com.rb.stacjepomiarowepowietrzapl.dagger.StationComponent;

import dagger.android.DaggerApplication;
import dagger.android.support.DaggerAppCompatActivity;

public class AppApplication extends Application {

    private static AppRoomDatabase appRoomDatabase;

    private AppComponent appComponent;

    private StationComponent stationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appRoomDatabase = Room.databaseBuilder(getApplicationContext(),
                AppRoomDatabase.class, "database-station")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

/*
        stationComponent = DaggerStationComponent.builder()
                .communeModule(new CommuneModule())
                .build();
*/

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .build();

    }


    public static AppRoomDatabase getAppRoomDatabase() {
        return appRoomDatabase;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
