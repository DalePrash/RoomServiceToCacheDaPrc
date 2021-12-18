package com.example.roomservicetocachedapr;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Pojo.class}, version = 1, exportSchema = true)
public  abstract class MovieDataBase extends RoomDatabase {
    private static volatile MovieDataBase INSTANCE;

    // abstract MovieDao movieAbs();
    public   abstract MovieOrigDao movieAbs();

    public static MovieDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MovieDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieDataBase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }



    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
    public   void destroyDataBase(){
        INSTANCE = null;
    }

}
