package com.klopkov.evgeny.perfectday.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.klopkov.evgeny.perfectday.R;
import com.klopkov.evgeny.perfectday.TaskActivity;
import com.klopkov.evgeny.perfectday.model.Category;
import com.klopkov.evgeny.perfectday.model.Task;
import com.klopkov.evgeny.perfectday.model.TaskList;

import java.util.List;

public class TaskListFragment extends Fragment {
    public static final String ARG_TASKLIST_ID = "com.klopkov.evgeny.perfectday.fragment.tasklist_id";
    private RecyclerView mTaskListRecyclerView;
    private TaskListFragment.TaskListAdapter mTaskListAdapter;
    private TaskList mTaskList;
    private int taskListId;

    public static TaskListFragment newInstance(int taskListId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TASKLIST_ID, taskListId);

        TaskListFragment fragment = new TaskListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        taskListId = (int) getArguments().getSerializable(ARG_TASKLIST_ID);
        mTaskList = Category.get(getActivity()).getTaskList(taskListId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tasklist, container, false);
        mTaskListRecyclerView = view.findViewById(R.id.tasklist_recycler_view);
        mTaskListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        List<Task> tasks = mTaskList.getTasks();

        if (mTaskListAdapter == null) {
            mTaskListAdapter = new TaskListAdapter(tasks);
            mTaskListRecyclerView.setAdapter(mTaskListAdapter);
        }
        else {
            mTaskListAdapter.notifyDataSetChanged();
        }
    }

    private class TaskListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleTextView;
        private TextView mReminderTextView;
        private CheckBox mTaskCheckBox;
        private Task mTask;

        TaskListHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.tasklist_item, parent, false));
            itemView.setOnClickListener(this);
            mTitleTextView = itemView.findViewById(R.id.task_title);
            mReminderTextView = itemView.findViewById(R.id.task_reminder);
            mTaskCheckBox = itemView.findViewById(R.id.task_checkbox);
        }

        public void bind(Task task) {
            mTask = task;
            mTitleTextView.setText(mTask.getTitle());
            mReminderTextView.setText(mTask.getDateFormatted());
            //TODO implement CheckBox
        }

        @Override
        public void onClick(View view) {
            Intent intent = TaskActivity.newIntent(getActivity(), mTask.getId(), taskListId);
            startActivity(intent);
        }
    }

    private class TaskListAdapter extends RecyclerView.Adapter<TaskListHolder> {
        private List<Task> mTasks;

        public TaskListAdapter(List<Task> tasks) {
            mTasks = tasks;
        }

        @Override
        public TaskListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new TaskListHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(TaskListHolder holder, int position) {
            Task task = mTasks.get(position);
            holder.bind(task);
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }
}
