package com.example.classwork_19_03;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterListUsers extends BaseAdapter {

    Context context;
    List<User> userList;
    LayoutInflater inflater;

    public AdapterListUsers(Context applicationContext, List<User> userArrayLists) {
        this.context = applicationContext;
        this.userList = userArrayLists;
        inflater = LayoutInflater.from(applicationContext);
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.user_item, null);
        TextView textView = view.findViewById(R.id.nameUser_textView);
        textView.setText(userList.get(position).name);

        return view;
    }
}


