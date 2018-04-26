package com.klopkov.evgeny.perfectday.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private int mId;
    private String mTitle;
    private List<Task> mTaskList;

    TaskList(Context context) {
        mTaskList = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            Task task = new Task();
            task.setTitle("TASK #" + i);
            task.setId(i);
            mTaskList.add(task);
        }
    }

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
