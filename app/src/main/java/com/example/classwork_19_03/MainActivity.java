package com.example.classwork_19_03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<User> userList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsersDataBase usersDataBase = App.getInstance().getUsersDataBase();
        UserDao userDao = usersDataBase.userDao();

        EditText enteredNameUser = findViewById(R.id.nameUser_editText);
        ListView listView = findViewById(R.id.users_listView);
        listView.setVisibility(View.INVISIBLE);

        findViewById(R.id.addUser_button).setOnClickListener(v -> {
            String userName = enteredNameUser.getText().toString().trim();
            if (!userName.isEmpty()) {
                userDao.insert(new User(userName));
                enteredNameUser.setText("");
            }
        });

        Button showUsersButton = findViewById(R.id.showUsers_button);

        showUsersButton.setOnClickListener(v -> {
                    if (listView.getVisibility() == View.VISIBLE) {
                        listView.setVisibility(View.INVISIBLE);
                        return;
                    }

                    userList = userDao.getAllUsers();

                    listView.setVisibility(View.VISIBLE);

                    AdapterListUsers adapterListUsers
                            = new AdapterListUsers(MainActivity.this, userList);
                    listView.setAdapter(adapterListUsers);
                }
        );

        findViewById(R.id.deleteAllUsers_button).setOnClickListener(v -> {
            userDao.deleteAll(userList);
            userList.clear();
            listView.setVisibility(View.INVISIBLE);
        });

    }
}

