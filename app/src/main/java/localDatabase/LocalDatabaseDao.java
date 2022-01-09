package localDatabase;

import android.database.sqlite.SQLiteException;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import localDatabase.tables.FriendsData;

/* Query:
*   insert into FriendsData(nikName, name, surname, bYear, bMonth, bDay, comments, type) values ("Mela", "Sinisa", "Melarosa", 2001, 1, 13, "Compleanno del mela.", 0)
*    */

/* DAO: Database Access Object. */
@Dao
public interface LocalDatabaseDao {
    @Transaction
    @Query("SELECT * FROM FriendsData")
    List<FriendsData> getAllFriendsData() throws SQLiteException;

    @Transaction
    @Insert
    void insertFriendsData(List<FriendsData> friendsData) throws SQLiteException;

    @Transaction
    @Query("DELETE FROM FriendsData WHERE id == :id")
    void deleteFriendsById(int id);
}