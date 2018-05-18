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
        TextView textView = holder.station_id;
        textView.setText(String.valueOf(station.getId()));
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

}
