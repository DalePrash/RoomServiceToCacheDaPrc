package com.example.roomservicetocachedapr;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
  Button button2;
  TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button2 = findViewById(R.id.buttonB);
        textView2 = findViewById(R.id.textB);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieDataBase      md = MovieDataBase.getDatabase(SecondActivity.this);
                MovieOrigDao  mdao = md.movieAbs();
                List<Pojo> k =mdao.getAlphabetizedWords();
                Log.i("a","a");
                //   Pojo sui = new Pojo(k.get[0].)
                Log.i("a","a");
               textView2.setText(k.get(0).getOriginal_title().toString());

            }
        });
    }
}
