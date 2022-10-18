package com.example.digitalsocity_new;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    final static String BASE_URL="https://anayaraj.000webhostapp.com/";
    public static Retrofit retrofit = null;

    public static  Retrofit getApiClient() {

        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        return retrofit;


    }
}
