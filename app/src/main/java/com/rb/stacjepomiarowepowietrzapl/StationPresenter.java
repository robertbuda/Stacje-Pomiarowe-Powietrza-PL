package com.rb.stacjepomiarowepowietrzapl;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.persistence.room.Dao;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class StationPresenter implements StationContract.Presenter, LifecycleObserver {

    private StationContract.View view;
    private Api api;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private List<Station> stations;
    private StationDao stationDao = AppApplication.getAppRoomDatabase().stationDao();

    public StationPresenter(StationContract.View view, Api api) {
        this.view = view;
        this.api = api;
        ((LifecycleOwner) this.view).getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        getStationsData();

    }

    @Override
    public void getStationsData() {
        compositeDisposable.add(
                api.getAllStations()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        stations -> {
                            //view.showData(stations);
                            addStationsToDatabase(stations);
                            showStationsFromDatabase();

                        },
                        throwable -> {
                            //TODO
                        },
                        () -> {
                            //Toast.makeText(,"Sorry",Toast.LENGTH_LONG).show();
                        })
        );
    }

    public void addStationsToDatabase (List <Station> stations){
        stationDao.insertStations(stations);
    }

    private void showStationsFromDatabase() {
        view.showData(stationDao.getAll());

    }
}
