package com.rb.stacjepomiarowepowietrzapl;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class City {

    @PrimaryKey
    @ColumnInfo(name = "city_id")
    private int cityId;

    @ColumnInfo(name = "city_name")
    private String name;

    @Embedded
    private Commune commune;


    public void setCityId(int cityId) { this.cityId = cityId; }

    public int getCityId() {
        return cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

}
