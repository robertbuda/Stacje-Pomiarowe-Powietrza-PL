package com.rb.stacjepomiarowepowietrzapl.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CommuneModule {

    public String communeName;
    public String districtName;
    public String provinceName;

    public CommuneModule(String communeName, String districtName, String provinceName) {
        this.communeName = communeName;
        this.districtName = districtName;
        this.provinceName = provinceName;
    }

    @Provides
    @Singleton
    String provideCommuneName(String commune) {
        return communeName;
    }

    @Provides
    @Singleton
    String provideDistrictName (String district) {
        return districtName;
    }


    @Provides
    @Singleton
    String provideProvinceName (String province) {
        return provinceName;
    }


    @Provides
    @Singleton
    Commune provideCommune(String commune, String district , String province) {
        return new Commune(communeName , districtName , provinceName);
    }

}
