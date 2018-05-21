package com.rb.stacjepomiarowepowietrzapl;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class CityData {

    @PrimaryKey
    @ColumnInfo(name = "city_id")
    public int cityId;

    public String name;


    //public Commune commune;

}
