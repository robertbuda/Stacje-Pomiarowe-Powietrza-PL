package com.rb.stacjepomiarowepowietrzapl;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.StationHolder>{

    private List<Station> stations;
    private Context context;
    private GoogleMap map;
    private double lat = 51.773884;
    private double lng = 19.441445;
    private double latS = 51.773884;
    private double lngS = 19.441445;
    private String name;
    private boolean flag = true;

    private StationDao stationMapDao = AppApplication.getAppRoomDatabase().stationDao();


    public class StationHolder extends RecyclerView.ViewHolder implements OnMapReadyCallback{

        @BindView(R.id.station_id)
        TextView station_id;

        @BindView(R.id.station_name)
        TextView station_name;

        @BindView(R.id.station_street)
        TextView station_street;

        @BindView(R.id.station_street_text)
        TextView station_street_text;

        @BindView(R.id.station_city_name)
        TextView station_city_name;

        @BindView(R.id.commune_name)
        TextView commune_name;

        @BindView(R.id.district_name)
        TextView district_name;

        @BindView(R.id.province_name)
        TextView province_name;

        @BindView(R.id.mapView)
        MapView mapView;

        @BindView(R.id.textShowMap)
        TextView textShowMap;


        public StationHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (flag) {
                        mapView.setVisibility(View.VISIBLE);
                        flag = false;
                        textShowMap.setText("Hide Map");
                        textShowMap.setTextColor(Color.RED);
                        mapView.onCreate(null);
                        mapView.onResume();
                        mapView.getMapAsync(new OnMapReadyCallback() {
                            @Override
                            public void onMapReady(GoogleMap googleMap) {
                                latS = stations.get(getAdapterPosition()).getGegrLat();
                                lngS = stations.get(getAdapterPosition()).getGegrLon();

                                map = googleMap;
                                LatLng latLng = new LatLng(latS, lngS);
                                for (int i = 0 ; i < stationMapDao.getAll().size(); i++) {
                                    lat = stationMapDao.getAll().get(i).getGegrLat();
                                    lng = stationMapDao.getAll().get(i).getGegrLon();
                                    map.addMarker(new MarkerOptions()
                                            .position(new LatLng( lat , lng ))
                                            .anchor(0.5f , 0.5f)
                                            .title(stationMapDao.getAll().get(i).getStationName()));
                                }
                                map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,11));
                            }
                        });

                    } else {
                    mapView.setVisibility(View.GONE);
                    flag = true;
                    textShowMap.setText("Show Map");
                    textShowMap.setTextColor(Color.GREEN);
                }
                }
            });
        }


        @Override
        public void onMapReady(GoogleMap googleMap) {
           /* map = googleMap;
            LatLng latLng = new LatLng(latS, lngS);
            for (int i = 0 ; i < stationMapDao.getAll().size(); i++) {
                lat = stationMapDao.getAll().get(i).getGegrLat();
                lng = stationMapDao.getAll().get(i).getGegrLon();
                map.addMarker(new MarkerOptions()
                        .position(new LatLng( lat , lng ))
                        .anchor(0.5f , 0.5f)
                        .title(stationMapDao.getAll().get(i).getStationName()));
            }
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,11));*/
        }
    }

    public StationAdapter(List<Station> stations, Context context) {
        this.stations = stations;
        this.context = context;
    }

    @NonNull
    @Override
    public StationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_station,parent,false);
        StationHolder stationHolder = new StationHolder(view);
        return stationHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StationAdapter.StationHolder holder, int position) {
        Station station = stations.get(position);

        TextView station_id = holder.station_id;
        station_id.setText(String.valueOf(station.getId()));

        TextView station_name = holder.station_name;
        station_name.setText(station.getStationName());

        TextView station_street = holder.station_street;
        station_street.setText(station.getAddressStreet());

        TextView station_city_name = holder.station_city_name;
        station_city_name.setText(station.getCity().getName());

        TextView commune_name = holder.commune_name;
        commune_name.setText(station.getCity().getCommune().getCommuneName());

        TextView district_name = holder.district_name;
        district_name.setText(station.getCity().getCommune().getDistrictName());

        TextView province_name = holder.province_name;
        province_name.setText(station.getCity().getCommune().getProvinceName());

        MapView mapView = holder.mapView;
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }


    public void showMarkerOnMap(){

        }

}
