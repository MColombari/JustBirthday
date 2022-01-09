package com.example.justbirthday.localDatabaseInteraction;

import android.database.sqlite.SQLiteException;

import java.util.List;

import localDatabase.tables.FriendsData;

public interface DatabaseManager {
    public List<FriendsData> getAllFriends() throws SQLiteException;
    public void insertAllFriends(List<FriendsData> inputFriends) throws SQLiteException;
    public void deleteFriendsById(int id) throws SQLiteException;
}
