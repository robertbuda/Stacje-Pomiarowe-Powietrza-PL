package com.rb.stacjepomiarowepowietrzapl;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class StationData {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "station_name")
    public String stationName;

    @ColumnInfo(name = "gegr_lat")
    public String gegrLat;

    @ColumnInfo(name = "gegr_lon")
    public String gegrLon;


    @Embedded
    public CityData cityData = new CityData();

    @ColumnInfo(name = "address_street")
    public String addressStreet;
}
