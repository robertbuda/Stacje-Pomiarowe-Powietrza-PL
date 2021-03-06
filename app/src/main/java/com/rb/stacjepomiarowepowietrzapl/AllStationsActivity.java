package com.rb.stacjepomiarowepowietrzapl;

import android.app.SearchManager;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class AllStationsActivity extends AppCompatActivity implements StationContract.View {

    @BindView(R.id.station_recycler_view)
    RecyclerView station_recycler_view;

    @Inject StationContract.Presenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations_all);
        ButterKnife.bind(this);

        ((AppApplication) getApplication()).getAppComponent().inject(this);
        presenter.setView(this);
        presenter.getStationsData();

    }

    private void doMySearch(String query) {
    }


    @Override
    public void showData(List<Station> stations) {
        StationAdapter stationAdapter = new StationAdapter(stations,this);
        station_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        station_recycler_view.setAdapter(stationAdapter);
        //stationAdapter.onViewDetachedFromWindow(station_recycler_view);
    }
}
