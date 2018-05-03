package com.klopkov.evgeny.perfectday.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.klopkov.evgeny.perfectday.R;
import com.klopkov.evgeny.perfectday.model.Category;
import com.klopkov.evgeny.perfectday.model.Task;
import com.klopkov.evgeny.perfectday.model.TaskList;

import java.util.List;
import java.util.UUID;

public class TaskFragment extends Fragment {

//    public static final String ARG_TASK_UUID = "com.klopkov.evgeny.perfectday.fragment.task_uuid";
    public static final String ARG_TASK_ID = "com.klopkov.evgeny.perfectday.fragment.task_id";
    public static final String ARG_TASKLIST_ID = "com.klopkov.evgeny.perfectday.fragment.tasklist_id";
    private Task mTask;
    private EditText mTitleEditText;

    /*@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID taskUUId = (UUID) getArguments().getSerializable(ARG_TASK_UUID);
        mTask =
    }

    public static TaskFragment newInstance(UUID taskUUID) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_TASK_UUID, taskUUID);

        TaskFragment fragment = new TaskFragment();
        fragment.setArguments(args);
        return fragment;
    }*/

    public static TaskFragment newInstance(int taskId, int taskListId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TASK_ID, taskId);
        args.putInt(ARG_TASKLIST_ID, taskListId);

        TaskFragment fragment = new TaskFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int taskId = (int) getArguments().getSerializable(ARG_TASK_ID);
        int taskListId = (int) getArguments().getSerializable(ARG_TASKLIST_ID);
        mTask = Category.get(getActivity()).getTaskList(taskListId).getTask(taskId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_fragment, container, false);
        mTitleEditText = view.findViewById(R.id.task_title_edittext);
        mTitleEditText.setText(mTask.getTitle());
        return view;
    }
}
