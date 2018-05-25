package com.rb.stacjepomiarowepowietrzapl;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity
public class Station {

    @PrimaryKey
    private Integer id;

    @ColumnInfo(name = "station_name")
    private String stationName;

    @ColumnInfo(name = "gegr_lat")
    private double gegrLat;

    @ColumnInfo(name = "gegr_lon")
    private double gegrLon;

    @Embedded
    private City city;

    @ColumnInfo(name = "address_street")
    private String addressStreet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public double getGegrLat() {
        return gegrLat;
    }

    public void setGegrLat(double gegrLat) {
        this.gegrLat = gegrLat;
    }

    public double getGegrLon() {
        return gegrLon;
    }

    public void setGegrLon(double gegrLon) {
        this.gegrLon = gegrLon;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

}
