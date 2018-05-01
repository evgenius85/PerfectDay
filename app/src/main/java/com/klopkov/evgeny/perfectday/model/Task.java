package com.klopkov.evgeny.perfectday.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private int mId;
    private String mTitle;
    private Date mReminder;
    private boolean mSolved;

    public boolean isSolved() {
        return mSolved;
    }

    public Task setSolved(boolean solved) {
        mSolved = solved;
        return this;
    }

    public Task() {
        mReminder = new Date();
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
