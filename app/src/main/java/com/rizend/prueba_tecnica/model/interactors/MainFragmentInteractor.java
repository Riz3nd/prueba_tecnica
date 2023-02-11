package com.rizend.prueba_tecnica.model.interactors;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.util.Log;

import com.google.gson.JsonObject;
import com.rizend.prueba_tecnica.api.RetrofitClient;
import com.rizend.prueba_tecnica.interfaces.IMainFragment;
import com.rizend.prueba_tecnica.interfaces.IServiceUserApi;
import com.rizend.prueba_tecnica.model.usermodel.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainFragmentInteractor implements IMainFragment.Interator {
    private IMainFragment.Presenter presenter;
    private Retrofit client;

    public MainFragmentInteractor(IMainFragment.Presenter presenter) {
        this.presenter = presenter;
        this.client = RetrofitClient.getClient();
    }

    @Override
    public void getAllContacts() {
        IServiceUserApi service = client.create(IServiceUserApi.class);
        service.getAllcontacts().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                if (response.isSuccessful()) {
                    presenter.showAllContacts(response.body());
                    presenter.showProgressBar();
                }else {
                    presenter.onFailureConsult();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                presenter.onFailureConsult();
                Log.e("Retrofit", t.getMessage());
            }

        });
    }
}
