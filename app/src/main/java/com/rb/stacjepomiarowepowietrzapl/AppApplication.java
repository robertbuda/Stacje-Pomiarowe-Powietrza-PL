package com.rb.stacjepomiarowepowietrzapl;

import android.app.Application;
import android.arch.persistence.room.Room;

public class AppApplication extends Application {

    private static AppRoomDatabase appRoomDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        appRoomDatabase = Room.databaseBuilder(getApplicationContext(),
                AppRoomDatabase.class, "database-station")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public static AppRoomDatabase getAppRoomDatabase() {
        return appRoomDatabase;
    }
}
