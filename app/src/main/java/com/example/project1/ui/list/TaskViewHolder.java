package com.example.project1.ui.list;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.data.list.Todo;

class TaskViewHolder extends RecyclerView.ViewHolder {
    TextView taskDisplay;

    public TaskViewHolder(View itemView) {
        super(itemView);
        taskDisplay = itemView.findViewById(R.id.task_display);
    }

    public void bindTask(Todo todo) {
        taskDisplay.setText(todo.getName());
    }
}
