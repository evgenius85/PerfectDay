package com.klopkov.evgeny.perfectday;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.klopkov.evgeny.perfectday.fragment.TaskFragment;

import java.util.UUID;

public class TaskActivity extends SingleFragmentActivity {
/*    private static final String EXTRA_TASK_UUID = "com.klopkov.evgeny.perfectday.task_uuid";

    public static Intent newIntent(Context packageContext, UUID taskUUID) {
        Intent intent = new Intent(packageContext, TaskActivity.class);
        intent.putExtra(EXTRA_TASK_UUID, taskUUID);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID taskUUID = (UUID) getIntent().getSerializableExtra(EXTRA_TASK_UUID);
        return TaskFragment.newInstance(taskUUID);
    }*/

    private static final String EXTRA_TASK_ID = "com.klopkov.evgeny.perfectday.task_id";
    private static final String EXTRA_TASKLIST_ID = "com.klopkov.evgeny.perfectday.tasklist_id";

    public static Intent newIntent(Context packageContext, int taskId, int taskListId) {
        Intent intent = new Intent(packageContext, TaskActivity.class);
        intent.putExtra(EXTRA_TASK_ID, taskId);
        intent.putExtra(EXTRA_TASKLIST_ID, taskListId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        int taskId = (int) getIntent().getSerializableExtra(EXTRA_TASK_ID);
        int taskListId = (int) getIntent().getSerializableExtra(EXTRA_TASKLIST_ID);
        return TaskFragment.newInstance(taskId, taskListId);
    }
}
