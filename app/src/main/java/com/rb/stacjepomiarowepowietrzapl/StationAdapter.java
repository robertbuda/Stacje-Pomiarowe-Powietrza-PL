package com.rb.stacjepomiarowepowietrzapl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.StationHolder>{

    private List<Station> stations;
    private Context context;


    public class StationHolder extends RecyclerView.ViewHolder {

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


        public StationHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
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

    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

}
