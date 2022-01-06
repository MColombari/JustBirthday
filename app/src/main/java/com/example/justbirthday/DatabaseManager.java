package com.example.justbirthday;

import java.util.List;

import localDatabase.tables.FriendsData;

public interface DatabaseManager {
    public List<FriendsData> getAllFriends();
    public void insertAllFriends(List<FriendsData> inputFriends);
}
