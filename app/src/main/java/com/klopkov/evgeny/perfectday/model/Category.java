package com.klopkov.evgeny.perfectday.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private static Category sCategory;
    private List<TaskList> mCategories;

    public static Category get(Context context) {
        if (sCategory == null) {
            sCategory = new Category(context);
        }
        return sCategory;
    }

    private Category(Context context) {
        mCategories = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            TaskList tl = new TaskList(context);
            tl.setTitle("LIST #" + i);
            tl.setId(i);
            mCategories.add(tl);
        }
    }

    public List<TaskList> getTaskLists() {
        return mCategories;
    }

    public TaskList getTaskList(int id) {
        return mCategories.get(id);
    }
}
