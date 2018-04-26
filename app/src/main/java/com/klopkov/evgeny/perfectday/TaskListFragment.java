package com.klopkov.evgeny.perfectday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klopkov.evgeny.perfectday.model.Category;
import com.klopkov.evgeny.perfectday.model.TaskList;

public class TaskListFragment extends Fragment {
    private TaskList mTaskList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int taskListId = (int) getActivity().getIntent().getSerializableExtra(TaskListActivity.EXTRA_TASKLIST_ID);
        mTaskList = Category.get(getActivity()).getTaskList(taskListId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
