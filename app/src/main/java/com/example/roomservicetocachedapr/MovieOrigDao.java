package com.example.roomservicetocachedapr;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;



import java.util.List;
@Dao
public interface MovieOrigDao {
    @Query("SELECT * FROM mov_table")
    List<Pojo> getAlphabetizedWords();

    // @Insert(onConflict = OnConflictStrategy.IGNORE)
    //  @Insert
    //  void insert(MovieList nTitle);
// it will replace previous data when entering
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Pojo nTitle);


    @Delete
    void delete(Pojo nTitle);

    @Query("DELETE FROM mov_table")
    void deleteAll();

    // @RawQuery("SELECT * FROM news_table")




}
