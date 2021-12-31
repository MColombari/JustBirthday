package com.example.justbirthday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    RecyclerView friendsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //This line will enable full screen.
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        friendsRecyclerView = (RecyclerView) findViewById(R.id.FriendsRecyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter();
        friendsRecyclerView.setAdapter(recyclerViewAdapter);
        /* I need to use LinearLayout because doesn't exits any Manager for ConstraintLayout. */
        friendsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}