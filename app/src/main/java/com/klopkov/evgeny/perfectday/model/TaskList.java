package com.klopkov.evgeny.perfectday.model;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private int mId;
    private String mTitle;
    private List<Task> mTaskList;

    public TaskList(String title, int id) {
        mTitle = title;
        mId = id;
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

    public List<Task> getTasks() {
        return mTaskList;
    }

    public Task getTask(int id) {
        return mTaskList.get(id);
    }
}
