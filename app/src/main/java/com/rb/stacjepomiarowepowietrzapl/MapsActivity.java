package com.rb.stacjepomiarowepowietrzapl;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private StationDao stationMapDao = AppApplication.getAppRoomDatabase().stationDao();
    private double lat;
    private double lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setMapToolbarEnabled(true);

        LatLng latLng = new LatLng(51.773884, 19.441445);

        for (int i = 0 ; i < stationMapDao.getAll().size(); i++) {
            lat = stationMapDao.getAll().get(i).getGegrLat();
            lng = stationMapDao.getAll().get(i).getGegrLon();

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng( lat , lng ))
                    .anchor(0.5f , 0.5f)
                    .title(stationMapDao.getAll().get(i).getStationName()));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));


        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

            }
        });
    }
}

