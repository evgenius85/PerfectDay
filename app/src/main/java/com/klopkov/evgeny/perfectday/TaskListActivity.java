package com.klopkov.evgeny.perfectday;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tasklist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Initiate adding of the new task in current list
        AlertDialog aboutDialog = new AlertDialog.Builder(TaskListActivity.this).create();
        aboutDialog.setTitle("Adding task");
        aboutDialog.setMessage("Under construction");
        aboutDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        aboutDialog.show();
        return true;
    }
}
