package com.example.roomservicetocachedapr;

/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

/**
 * View Model to keep a reference to the word repository and
 * an up-to-date list of all words.
 */

public class WordViewModel extends AndroidViewModel {

    private  MovieRepository repository;

  //  private WordRepository mRepository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
  //  private final LiveData<List<Word>> mAllWords;
   // private final LiveData<Pojo> mAllWord;

    public WordViewModel(Application application) {
        super(application);
      //  repository = new MovieRepository(application);
        repository = new MovieRepository();

    }
        //   mRepository = new WordRepository(application);
        // mAllWords = mRepository.getAllWords();

      /*  NetServe apiService =
                APICl.getClient().create(NetServe.class);

        LiveData<Pojo> call = apiService.getTopRatedMoviesLiveLive();
        mAllWord =apiService.getTopRatedMoviesLiveLive();
       // mAllWord = mRepository.getAllWord();
    }

  LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }



    LiveData<Pojo> getAllWord() {
        return mAllWord;
    }


   void insert(Word word) {
    mRepository.insert(word);
    }




    LiveData<List<Pojo>> getAllWord() {
        return mAllWord;
    }

     */

        @SuppressWarnings({"FieldCanBeLocal"})
         MutableLiveData<Pojo> listOfMovies = new MutableLiveData<>();


        public MutableLiveData<Pojo> getMoviesRepository (String category,int page){
            listOfMovies = loadMoviesData(category, page);
            return listOfMovies;
        }


        private MutableLiveData<Pojo> loadMoviesData (String categofry,int page){
            return repository.getListOfMoviesOutputs(categofry, page);
        }


}
