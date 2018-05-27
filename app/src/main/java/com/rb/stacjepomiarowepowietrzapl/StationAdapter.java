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
    GoogleMap map;
    private double lat;
    private double lng;
    private String name;
    private boolean flag = true;


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


            mapView.onCreate(null);
            mapView.getMapAsync(this);
            mapView.onResume();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (flag) {
                        mapView.setVisibility(View.VISIBLE);
                        flag = false;
                        textShowMap.setText("Hide Map");
                        textShowMap.setTextColor(Color.RED);
                    } else {
                    mapView.setVisibility(View.GONE);
                    flag = true;
                    textShowMap.setText("Show Map");
                    textShowMap.setTextColor(Color.GREEN);

                }}
            });
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setMapToolbarEnabled(true);

            Station station = stations.get(getAdapterPosition());
            lat = station.getGegrLat();
            lng = station.getGegrLon();
            name = station.getStationName();
            Toast.makeText(itemView.getContext(), ""+lat + " " + lng, Toast.LENGTH_SHORT).show();

            LatLng latLng = new LatLng(lat,lng);

                map.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(name));

            //map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));


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
        mapView.onStart();
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

}
