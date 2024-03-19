package com.example.classwork_19_03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<User> userList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList.add(new User("User1"));
        userList.add(new User("User2"));
        userList.add(new User("User3"));
        userList.add(new User("User4"));

        EditText enteredNameUser = findViewById(R.id.nameUser_editText);
        ListView listView = findViewById(R.id.users_listView);
        listView.setVisibility(View.INVISIBLE);

        findViewById(R.id.addUser_button).setOnClickListener(v -> {
            String userName = enteredNameUser.getText().toString().trim();
            if (!userName.isEmpty()) {
                userList.add(new User(userName));
                enteredNameUser.setText("");
            }
        });

        Button showUsersButton = findViewById(R.id.showUsers_button);

        showUsersButton.setOnClickListener(v -> {
            listView.setVisibility(View.VISIBLE);

            AdapterListUsers adapterListUsers
                    = new AdapterListUsers(MainActivity.this, userList);
            listView.setAdapter(adapterListUsers);
            adapterListUsers.notifyDataSetChanged();
        }
        );

    }
}

