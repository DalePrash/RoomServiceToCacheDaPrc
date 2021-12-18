package com.example.roomservicetocachedapr;
import androidx.lifecycle.LiveData;

import retrofit2.Call;
import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface NetServe {

    @GET("550?api_key=b199eab06bc931ed71cd20c95e4b2bb3")
    Call<Pojo> getTopRatedMovies();

    @GET("550?api_key=b199eab06bc931ed71cd20c95e4b2bb3")
    LiveData<Pojo> getTopRatedMoviesLiveLive();

    @GET("550?api_key=b199eab06bc931ed71cd20c95e4b2bb3")
    Call<Pojo> getTopRatedMoviesLive();

}
