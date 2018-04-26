package com.klopkov.evgeny.perfectday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.klopkov.evgeny.perfectday.model.Category;
import com.klopkov.evgeny.perfectday.model.Task;
import com.klopkov.evgeny.perfectday.model.TaskList;

import java.util.List;

public class TaskListFragment extends Fragment {
    private RecyclerView mTaskListRecyclerView;
    private TaskListFragment.TaskListAdapter mTaskListAdapter;
    private TaskList mTasks;
    int taskListId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        taskListId = (int) getActivity().getIntent().getSerializableExtra(TaskListActivity.EXTRA_TASKLIST_ID);
        mTasks = Category.get(getActivity()).getTaskList(taskListId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tasklist, container, false);
        mTaskListRecyclerView = view.findViewById(R.id.tasklist_recycler_view);
        mTaskListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        List<Task> tasks = mTasks.getTasks();
        mTaskListAdapter = new TaskListAdapter(tasks);
        mTaskListRecyclerView.setAdapter(mTaskListAdapter);
    }

    private class TaskListHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private Task mTask;

        public TaskListHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.tasklist_item, parent, false));
            mTitleTextView = itemView.findViewById(R.id.task_title);
        }

        public void bind(Task task) {
            mTask = task;
            mTitleTextView.setText(mTask.getTitle());
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
