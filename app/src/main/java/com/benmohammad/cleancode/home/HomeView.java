package com.benmohammad.cleancode.home;

import com.benmohammad.cleancode.models.CityListResponse;

public interface HomeView {

    void showWait();
    void removeWait();
    void onFailure(String appErrorMessage);
    void getCityListSuccess(CityListResponse cityListResponse);
}
