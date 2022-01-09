package com.example.justbirthday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;

import com.example.justbirthday.localDatabaseInteraction.HomeInitializer;

import java.util.ArrayList;

import localDatabase.DatabaseManagerImplementation;

public class MainActivity extends AppCompatActivity {
    RecyclerView friendsRecyclerView;

    ArrayList<SingleRowRecycleView> singleRowRecycleViewArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //This line will enable full screen.
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        friendsRecyclerView = (RecyclerView) findViewById(R.id.FriendsRecyclerView);

        HomeInitializer homeInitializer = new HomeInitializer(new DatabaseManagerImplementation(getApplicationContext()), friendsRecyclerView, getApplicationContext());
        Thread thread = new Thread(homeInitializer);
        thread.start();
    }
}