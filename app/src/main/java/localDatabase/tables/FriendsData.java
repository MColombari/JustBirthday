package localDatabase.tables;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity
public class FriendsData {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @NonNull
    public String nikName;
    @NonNull
    public String name;
    @NonNull
    public String surname;
    @NonNull
    public int bYear;
    @NonNull
    public int bMonth;
    @NonNull
    public int bDay;
    @NonNull
    public String comments;
    @NonNull
    public int type;

    public FriendsData(int id, @NonNull String nikName, @NonNull String name, @NonNull String surname, int bYear, int bMonth, int bDay, @NonNull String comments, int type) {
        this.id = id;
        this.nikName = nikName;
        this.name = name;
        this.surname = surname;
        this.bYear = bYear;
        this.bMonth = bMonth;
        this.bDay = bDay;
        this.comments = comments;
        this.type = type;
    }

    public int getId() {
        return id;
    }
    @NonNull
    public String getNikName() {
        return nikName;
    }
    @NonNull
    public String getName() {
        return name;
    }
    @NonNull
    public String getSurname() {
        return surname;
    }
    public int getbYear() {
        return bYear;
    }
    public int getbMonth() {
        return bMonth;
    }
    public int getbDay() {
        return bDay;
    }
    @NonNull
    public String getComments() {
        return comments;
    }
    public int getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNikName(@NonNull String nikName) {
        this.nikName = nikName;
    }
    public void setName(@NonNull String name) {
        this.name = name;
    }
    public void setSurname(@NonNull String surname) {
        this.surname = surname;
    }
    public void setbYear(int bYear) {
        this.bYear = bYear;
    }
    public void setbMonth(int bMonth) {
        this.bMonth = bMonth;
    }
    public void setbDay(int bDay) {
        this.bDay = bDay;
    }
    public void setComments(@NonNull String comments) {
        this.comments = comments;
    }
    public void setType(int type) {
        this.type = type;
    }
}
