package com.klopkov.evgeny.perfectday.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.klopkov.evgeny.perfectday.R;
import com.klopkov.evgeny.perfectday.model.Category;
import com.klopkov.evgeny.perfectday.model.Task;

public class TaskFragment extends Fragment {

    public static final String ARG_TASK_ID = "com.klopkov.evgeny.perfectday.fragment.task_id";
    public static final String ARG_TASKLIST_ID = "com.klopkov.evgeny.perfectday.fragment.tasklist_id";
    private Task mTask;
    private EditText mTitleEditText;
    private TextView mReminderTextView;

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
        mTitleEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTask.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mReminderTextView = view.findViewById(R.id.task_reminder_time);
        mReminderTextView.setText(mTask.getDateFormatted());
        return view;
    }
}