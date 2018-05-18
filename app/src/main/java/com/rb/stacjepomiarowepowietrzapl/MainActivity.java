package com.rb.stacjepomiarowepowietrzapl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btSeeAll)
    Button btSeeAll;

    @BindView(R.id.btSeeOnMap)
    Button btSeeOnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btSeeAll)
    public void showAllStationsActivity() {
        Intent intent = new Intent(this,AllStationsActivity.class);
        startActivity(intent);
    }
}
