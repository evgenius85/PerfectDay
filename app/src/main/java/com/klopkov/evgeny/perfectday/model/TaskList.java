package com.klopkov.evgeny.perfectday.model;

public class TaskList {
    private int mId;
    private String mTitle;

    public int getId() {
        return mId;
    }

    public TaskList setId(int id) {
        mId = id;
        return this;
    }

    public String getTitle() {
        return mTitle;
    }

    public TaskList setTitle(String title) {
        mTitle = title;
        return this;
    }
}
