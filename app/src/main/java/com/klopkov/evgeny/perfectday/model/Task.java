package com.klopkov.evgeny.perfectday.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID mUUID;
    private int mId;
    private String mTitle;
    private Date mReminder;
    private boolean mSolved;

    public Task() {
        mReminder = new Date();
        mUUID = UUID.randomUUID();
    }

    public UUID getUUID() {
        return mUUID;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public Task setSolved(boolean solved) {
        mSolved = solved;
        return this;
    }

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

    public String getDateFormatted() {
        DateFormat df = DateFormat.getDateInstance(SimpleDateFormat.FULL);
        return df.format(mReminder);
    }
}
