package com.klopkov.evgeny.perfectday.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private static Category sCategory;
    private List<TaskList> mCategories = new ArrayList<>();

    public static Category get(Context context) {
        if (sCategory == null) {
            sCategory = new Category(context);
        }
        return sCategory;
    }

    private Category(Context context) {
        mCategories.add(new TaskList("Morning habits", mCategories.size()));
        mCategories.add(new TaskList("Daily habits", mCategories.size()));
        mCategories.add(new TaskList("Evening habits", mCategories.size()));
        mCategories.add(new TaskList("Important", mCategories.size()));
        mCategories.add(new TaskList("Eat this frogs", mCategories.size()));
        mCategories.add(new TaskList("Chaos", mCategories.size()));
    }

    public List<TaskList> getTaskLists() {
        return mCategories;
    }

    public TaskList getTaskList(int id) {
        return mCategories.get(id);
    }
}
