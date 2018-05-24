package com.rb.stacjepomiarowepowietrzapl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class AllStationsActivity extends AppCompatActivity implements StationContract.View{

    @BindView(R.id.station_recycler_view)
    RecyclerView station_recycler_view;

    private StationContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations_all);
        ButterKnife.bind(this);

        startRetroFit();
    }

    private void startRetroFit() {
        RxJava2CallAdapterFactory rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();

        presenter = new StationPresenter(this, retrofit.create(Api.class));
    }

    @Override
    public void showData(List<Station> stations) {
        StationAdapter stationAdapter = new StationAdapter(stations,this);
        station_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        station_recycler_view.setAdapter(stationAdapter);
        stationAdapter.notify();
    }
}
