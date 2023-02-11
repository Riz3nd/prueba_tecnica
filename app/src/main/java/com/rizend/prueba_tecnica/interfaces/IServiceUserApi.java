package com.rizend.prueba_tecnica.interfaces;

import com.rizend.prueba_tecnica.model.usermodel.User;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IServiceUserApi {
    @GET("/users")
    Call<ArrayList<User>> getAllcontacts();
}
