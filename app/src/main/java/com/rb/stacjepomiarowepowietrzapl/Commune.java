package com.rb.stacjepomiarowepowietrzapl;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Commune {

    @PrimaryKey
    @ColumnInfo(name = "commune_name")
    private String communeName;

    @ColumnInfo(name = "district_name")
    private String districtName;

    @ColumnInfo(name = "province_name")
    private String provinceName;


    public String getCommuneName() {
        return communeName;
    }

    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }


    }

