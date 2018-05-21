package com.rb.stacjepomiarowepowietrzapl;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {StationData.class} , version = 1)
public abstract class AppRoomDatabase extends RoomDatabase {

    public abstract StationDao stationDao();
}
