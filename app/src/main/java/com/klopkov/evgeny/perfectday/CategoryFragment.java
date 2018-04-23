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
import com.klopkov.evgeny.perfectday.model.TaskList;

import java.util.List;

public class CategoryFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CategoryAdapter mCategoryAdapter;

/*    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        mCrimeRecyclerView = view.findViewById(R.id.category_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        Category category = Category.get(getActivity());
        List<TaskList> categories = category.getTaskLists();
        mCategoryAdapter = new CategoryAdapter(categories);
        mCrimeRecyclerView.setAdapter(mCategoryAdapter);
    }

    private class CategoryHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TaskList mCategory;

        public CategoryHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.category_item, parent, false));
            mTitleTextView = itemView.findViewById(R.id.category_title);
        }

        public void bind(TaskList category) {
            mCategory = category;
            mTitleTextView.setText(mCategory.getTitle());
        }
    }

    private class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder> {
        private List<TaskList> mCategories;

        public CategoryAdapter(List<TaskList> categories) {
            mCategories = categories;
        }

        @Override
        public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CategoryHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(CategoryHolder holder, int position) {
            // TODO что это за метод get у mCategories?
            TaskList category = mCategories.get(position);
            holder.bind(category);
        }

        @Override
        public int getItemCount() {
            return mCategories.size();
        }
    }
}