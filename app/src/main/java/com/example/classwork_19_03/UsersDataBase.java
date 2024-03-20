package com.example.classwork_19_03;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UsersDataBase extends RoomDatabase {
    public abstract UserDao userDao();

}
