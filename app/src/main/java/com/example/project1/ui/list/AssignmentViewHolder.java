package com.example.project1.ui.list;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.data.list.Assignment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class AssignmentViewHolder extends RecyclerView.ViewHolder {
    TextView assignCourse, assignName, assignDue;

    public AssignmentViewHolder(View itemView) {
        super(itemView);
        assignCourse = itemView.findViewById(R.id.assign_course);
        assignName = itemView.findViewById(R.id.assign_name);
        assignDue = itemView.findViewById(R.id.assign_due);
    }

    public void bindAssignment(Assignment assignment) {
        assignCourse.setText(assignment.getAssociatedClass().getName());
        assignName.setText(assignment.getName());
        assignDue.setText(formatDate(assignment.getDue()));
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(date);
    }
}
