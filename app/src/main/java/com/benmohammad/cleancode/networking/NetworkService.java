package com.benmohammad.cleancode.networking;

import com.benmohammad.cleancode.models.CityListResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface NetworkService {

    @GET("v1/city")
    Observable<CityListResponse> getCityList();
}
