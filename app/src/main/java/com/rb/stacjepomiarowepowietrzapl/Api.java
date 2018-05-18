package com.rb.stacjepomiarowepowietrzapl;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "http://api.gios.gov.pl/pjp-api/rest/station/";

    @GET("findAll")
    Flowable<List<Station>> getAllStations();


}
