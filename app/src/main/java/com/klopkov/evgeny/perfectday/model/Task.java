package com.klopkov.evgeny.perfectday.model;

public class Task {
    private int mId;
    private String mTitle;

    public int getId() {
        return mId;
    }

    public Task setId(int id) {
        mId = id;
        return this;
    }

    public String getTitle() {
        return mTitle;
    }

    public Task setTitle(String title) {
        mTitle = title;
        return this;
    }
}
