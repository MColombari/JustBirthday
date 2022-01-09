package localDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteException;

import androidx.room.Room;

import com.example.justbirthday.localDatabaseInteraction.DatabaseManager;

import java.util.List;

import localDatabase.tables.FriendsData;

public class DatabaseManagerImplementation implements DatabaseManager {
    private LocalDatabaseDao localDatabaseDao;

    public DatabaseManagerImplementation(Context contextDatabase) {
        LocalDatabase localDatabase = Room.databaseBuilder(contextDatabase, LocalDatabase.class, "LocalDatabase")
                .fallbackToDestructiveMigration()
                .build();
        localDatabaseDao = localDatabase.localDatabaseDao();
    }

    @Override
    public List<FriendsData> getAllFriends() throws SQLiteException {
        return localDatabaseDao.getAllFriendsData();
    }

    @Override
    public void insertAllFriends(List<FriendsData> inputFriends) throws SQLiteException {
        localDatabaseDao.insertFriendsData(inputFriends);
    }

    @Override
    public void deleteFriendsById(int id) {
        localDatabaseDao.deleteFriendsById(id);
    }
}
