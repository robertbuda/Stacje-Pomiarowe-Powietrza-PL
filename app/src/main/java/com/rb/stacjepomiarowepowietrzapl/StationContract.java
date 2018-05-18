package com.rb.stacjepomiarowepowietrzapl;

import java.util.List;

public interface StationContract {

    interface Presenter {

        void getStationsData();
    }

    interface View {

        void showData(List<Station> stations);
    }
}
