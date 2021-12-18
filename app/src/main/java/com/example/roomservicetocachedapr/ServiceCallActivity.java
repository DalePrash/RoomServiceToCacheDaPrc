package com.example.roomservicetocachedapr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceCallActivity extends AppCompatActivity {
Button button1;
    WordViewModel mWordViewModelB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.buttonA);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("second");
                startActivity(intent);
            }
        });
        regularServiceLiveData();

    }


     void regularServiceCall()
    {

        NetServe apiService =
                APICl.getClient().create(NetServe.class);

        Call<Pojo> call = apiService.getTopRatedMovies();

        call.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                Log.i("a","a");
                Thread thread = new Thread(){
                    public void run(){

                        MovieDataBase      md = MovieDataBase.getDatabase(ServiceCallActivity.this);
                        MovieOrigDao  mdao = md.movieAbs();

                        mdao.insert(response.body());

                        Log.i("a","a");

                    }
                };

                thread.start();

            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {
                Log.i("a","a");

            }
        });


    }


     void regularServiceLiveData()
    {

   //     NetServe apiService =
       //         APICl.getClient().create(NetServe.class);

     //   LiveData<Pojo> call = apiService.getTopRatedMoviesLive();

        WordViewModel mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
       // mWordViewModel.init();
        //        mWordViewModel.getAllWord().observe(this, words -> {

        mWordViewModel.getMoviesRepository("s",1).observe(this,movieResponse->
        {
            Log.i("a","a");

        }
    );
                //viewModelMovieOutputs.getMoviesRepository().observe(this, movieResponse -> {

        /*
mWordViewModel.getAllWord().observe(this,words->{
    Log.i("a","a");
});

         */
      /*
        call.observe(this,pojo->{
            Log.i("a","a");
        });


       */

    }




}
