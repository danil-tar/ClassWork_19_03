package com.example.classwork_19_03;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;

    public User(String name) {
        this.name = name;
    }
}
