package com.example.roomservicetocachedapr;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "mov_table")
public class Pojo {

    boolean adult;

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    int id;

    double budget;

    @SerializedName("original_language")
    String original_language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("original_title")
    String original_title;

    public Pojo(int id,boolean adult, String original_language, String original_title) {
        this.adult = adult;
        this.budget = budget;
        this.original_language = original_language;
        this.original_title = original_title;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }
}
