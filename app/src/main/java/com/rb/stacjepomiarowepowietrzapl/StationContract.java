package com.rb.stacjepomiarowepowietrzapl;


import java.util.List;

public interface StationContract {

    interface Presenter {

        void getStationsData();

        void setView(StationContract.View view);

    }

    interface View {

        void showData(List<Station> stations);
    }
}
