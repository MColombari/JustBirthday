package com.example.justbirthday.localDatabaseInteraction;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.justbirthday.RecyclerViewAdapter;
import com.example.justbirthday.SingleRowRecycleView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import localDatabase.tables.FriendsData;

public class HomeInitializer implements Runnable{
    DatabaseManager databaseManager;
    RecyclerView friendsRecyclerView;
    Context applicationContext;

    public HomeInitializer(DatabaseManager databaseManager, RecyclerView friendsRecyclerView, Context applicationContext) {
        this.databaseManager = databaseManager;
        this.friendsRecyclerView = friendsRecyclerView;
        this.applicationContext = applicationContext;
    }

    @Override
    public void run() {
        ArrayList<SingleRowRecycleView> singleRowRecycleViewArrayList = new ArrayList<>();
        List<FriendsData> friendsDataList = databaseManager.getAllFriends();

        for(FriendsData friendsData : friendsDataList){
            Date bDate = new Date(friendsData.getbYear(), friendsData.getbMonth(), friendsData.getbDay());
            singleRowRecycleViewArrayList.add(new SingleRowRecycleView(
                                                    friendsData.getId(),
                                                    friendsData.getNikName(),
                                                    friendsData.getName(),
                                                    friendsData.getSurname(),
                                                    bDate,
                                                    friendsData.getComments(),
                                                    friendsData.getType()));
        }

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(singleRowRecycleViewArrayList, databaseManager);
        friendsRecyclerView.setAdapter(recyclerViewAdapter);
        /* I need to use LinearLayout because doesn't exits any Manager for ConstraintLayout. */
        friendsRecyclerView.setLayoutManager(new LinearLayoutManager(applicationContext));
    }
}
