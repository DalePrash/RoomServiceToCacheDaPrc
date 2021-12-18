package com.example.roomservicetocachedapr;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private final MutableLiveData<Pojo> listOfMovies = new MutableLiveData<>();
    //private static final NetServe myInterface;
    private static  NetServe myInterface;

    private static MovieRepository movieRepository;
    public static MovieRepository getInstance(){
        if (movieRepository == null){
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    public MovieRepository(){
        myInterface = APICl.getInterface();
    }



    public MutableLiveData<Pojo> getListOfMoviesOutputs(String category, int page) {
        Call<Pojo> listOfMovieOut = myInterface.getTopRatedMoviesLive();

        listOfMovieOut.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                listOfMovies.setValue(response.body());

            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {
                listOfMovies.postValue(null);

            }
        });
        return listOfMovies;
    }
}








