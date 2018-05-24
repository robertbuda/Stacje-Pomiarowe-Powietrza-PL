package com.rb.stacjepomiarowepowietrzapl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btSeeAll)
    Button btSeeAll;

    @BindView(R.id.btSeeOnMap)
    Button btSeeOnMap;

    @Inject
    Commune commune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       ((AppApplication) getApplication()).getAppComponent().inject(this);
        Log.e("Commune", commune.getCommuneName());
    }

    @OnClick(R.id.btSeeAll)
    public void showAllStationsActivity() {
        Intent intent = new Intent(this,AllStationsActivity.class);
        startActivity(intent);
    }
}
