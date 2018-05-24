package com.rb.stacjepomiarowepowietrzapl;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.rb.stacjepomiarowepowietrzapl.dagger.CommuneData;

@Entity
public class CityData {

    @PrimaryKey
    @ColumnInfo(name = "city_id")
    public int cityId;

    @ColumnInfo(name = "city_name")
    public String name;

    @Embedded
    public CommuneData communeData = new CommuneData();
}
