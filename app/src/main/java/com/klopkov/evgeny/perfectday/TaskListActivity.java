package com.klopkov.evgeny.perfectday;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.klopkov.evgeny.perfectday.fragment.TaskListFragment;

public class TaskListActivity extends SingleFragmentActivity {
    private static final String EXTRA_TASKLIST_ID = "com.klopkov.evgeny.perfectday.tasklist_id";

    public static Intent newIntent(Context packageContext, int taskListId) {
        Intent intent = new Intent(packageContext, TaskListActivity.class);
        intent.putExtra(EXTRA_TASKLIST_ID, taskListId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        int taskListId = (int) getIntent().getSerializableExtra(EXTRA_TASKLIST_ID);
        return TaskListFragment.newInstance(taskListId);
    }
}
