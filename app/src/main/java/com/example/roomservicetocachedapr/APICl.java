package com.example.roomservicetocachedapr;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICl {
    public static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    // GsonConverterFactory or JacksonConverterFactory
                    .build();
        }
        return retrofit;
    }
    public static NetServe getInterface() {

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    // GsonConverterFactory or JacksonConverterFactory
                    .build();
        }

        return retrofit.create(NetServe.class);
    }
    // https://api.themoviedb.org/3/movie/550?api_key=b199eab06bc931ed71cd20c95e4b2bb3
}
