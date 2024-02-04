package com.example.project1;// ListAdapter.java

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ToDoInput> todoList;
    private List<AssignmentInput> assignmentList;
    private List<ExamInput> examList;

    // Constructor to initialize data
    public ListAdapter(List<ToDoInput> todoList, List<AssignmentInput> assignmentList, List<ExamInput> examList) {
        this.todoList = todoList;
        this.assignmentList = assignmentList;
        this.examList = examList;
    }

    // ViewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.lv_list);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemTextView.setText(getItemText(position));
    }

    @Override
    public int getItemCount() {
        return todoList.size() + assignmentList.size() + examList.size();
    }

    // Get text for each item based on position
    private String getItemText(int position) {
        if (position < todoList.size()) {
            return todoList.get(position).getTask();
        } else if (position < todoList.size() + assignmentList.size()) {
            return assignmentList.get(position - todoList.size()).getAssignment();
        } else {
            return examList.get(position - todoList.size() - assignmentList.size()).getName();
        }
    }
}

