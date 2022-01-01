package com.example.justbirthday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Date;

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

        singleRowRecycleViewArrayList = new ArrayList<>();
        singleRowRecycleViewArrayList.add(new SingleRowRecycleView("Mela", "Sinisa", "Melarosa", new Date(2000, 2,12), "Porco D**", 0));

        friendsRecyclerView = (RecyclerView) findViewById(R.id.FriendsRecyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(singleRowRecycleViewArrayList);
        friendsRecyclerView.setAdapter(recyclerViewAdapter);
        /* I need to use LinearLayout because doesn't exits any Manager for ConstraintLayout. */
        friendsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}