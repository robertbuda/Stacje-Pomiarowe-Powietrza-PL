package com.rb.stacjepomiarowepowietrzapl;

public class City {

    private int cityId;
    private String name;
    private Commune commune;

    public Integer getId() {
        return cityId;
    }

    public void setId(int cityId) {
        this.cityId = cityId;
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
