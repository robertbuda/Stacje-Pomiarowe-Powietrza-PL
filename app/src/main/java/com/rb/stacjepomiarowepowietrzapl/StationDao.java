package com.rb.stacjepomiarowepowietrzapl;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StationDao {

    @Query("SELECT * FROM StationData")
    List<StationData> getAll();

    @Insert
    long insertStation(StationData stationData);

    @Delete
    void deleteStation(StationData stationData);

}
