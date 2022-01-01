package com.example.justbirthday;

import java.util.Date;

public class SingleRowRecycleView implements Comparable<SingleRowRecycleView> {
    private String nikName;
    private String name;
    private String surname;
    private Date birthdayDate;
    private String comments;
    private int sourceType; // 0 -> From user directly.

    private boolean expanded;

    public SingleRowRecycleView(String nikName, String name, String surname, Date birthdayDate, String comments, int sourceType) {
        this.nikName = nikName;
        this.name = name;
        this.surname = surname;
        this.birthdayDate = birthdayDate;
        this.comments = comments;
        this.sourceType = sourceType;
        expanded = false;
    }

    public String getNikName() {
        return nikName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public String getComments() {
        return comments;
    }

    public int getSourceType() {
        return sourceType;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public int compareTo(SingleRowRecycleView o) {
        return this.getBirthdayDate().compareTo(o.getBirthdayDate());
    }
}
