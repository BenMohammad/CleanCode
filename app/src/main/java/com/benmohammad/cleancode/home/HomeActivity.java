package com.benmohammad.cleancode.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.benmohammad.cleancode.BaseApp;
import com.benmohammad.cleancode.R;
import com.benmohammad.cleancode.models.CityListData;
import com.benmohammad.cleancode.models.CityListResponse;
import com.benmohammad.cleancode.networking.Service;

import javax.inject.Inject;

public class HomeActivity extends BaseApp implements HomeView {

    private RecyclerView list;
    @Inject
    public Service service;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);
        renderView();
        init();

        HomePresenter presenter = new HomePresenter(service, this);
        presenter.getCityList();


    }

    public void renderView() {
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        progressBar = findViewById(R.id.progress);
    }

    public void init() {
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void getCityListSuccess(CityListResponse cityListResponse) {
        HomeAdapter adpter = new HomeAdapter(getApplicationContext(), cityListResponse.getData(),
                new HomeAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(CityListData item) {
                        Toast.makeText(HomeActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
                    }
                });

        list.setAdapter(adpter);
    }
}
