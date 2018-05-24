package com.rb.stacjepomiarowepowietrzapl.dagger;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class CommuneData {

    @PrimaryKey
    @ColumnInfo(name = "commune_name")
    public String communeName;

    @ColumnInfo(name = "district_name")
    public String districtName;

    @ColumnInfo(name = "province_name")
    public String provinceName;


}
