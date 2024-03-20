package com.example.classwork_19_03;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    private static App instance;
    private UsersDataBase usersDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        usersDataBase = Room.databaseBuilder(getApplicationContext(),
                        UsersDataBase.class, "users-database")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public UsersDataBase getUsersDataBase() {
        return usersDataBase;
    }
}

