package com.rb.stacjepomiarowepowietrzapl;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StationDao {

    @Query("SELECT * FROM station")
    List<Station> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStations(List<Station> station);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFirstStation(Station station);

    @Delete
    void deleteStation(Station station);

    /*@Query("SELECT * FROM station WHERE gegr_lat LIKE :gegrLat AND gegr_lon LIKE :gegrLon ")
    List<Station> getAllPlaces(double gegrLat, double gegrLon);*/

}
