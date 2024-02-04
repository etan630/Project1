package com.example.project1.data.list;// ListAdapter.java

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_1 = 1;
    private static final int VIEW_TYPE_2 = 2;
    private static final int VIEW_TYPE_3 = 3;

    private List<ListItem> itemList;

    // Constructor and other methods...

    @Override
    public int getItemViewType(int position) {
        ListItem item = itemList.get(position);
        if (item instanceof Exam) {
            return VIEW_TYPE_1;
        } else if (item instanceof Todo) {
            return VIEW_TYPE_2;
        } else {
            return VIEW_TYPE_3;
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case VIEW_TYPE_1:
                View v_exam = inflater.inflate(R.layout.fragment_exam, parent, false);
                viewHolder = new ExamViewHolder(v_exam);
                break;

            case VIEW_TYPE_2:
                View v_task = inflater.inflate(R.layout.fragment_task, parent, false);
                viewHolder = new TaskViewHolder(v_task);
                break;

            case VIEW_TYPE_3:
                View v_assign = inflater.inflate(R.layout.fragment_assignment, parent, false);
                viewHolder = new AssignmentViewHolder(v_assign);
                break;

            default:
                throw new IllegalArgumentException("Invalid view type");
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListItem item = itemList.get(position);

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_1:
                ((ExamViewHolder) holder).bindExam((Exam) item);
                break;

            case VIEW_TYPE_2:
                ((TaskViewHolder) holder).bindTask((Todo) item);
                break;

            case VIEW_TYPE_3:
                ((AssignmentViewHolder) holder).bindAssignment((Assignment) item);
                break;

            default:
                throw new IllegalArgumentException("Invalid view type");
        }
    }

    private static class ExamViewHolder extends RecyclerView.ViewHolder {
        TextView examNameDisplay, examDateDisplay, examTimeDisplay, examLocationDisplay;

        public ExamViewHolder(View itemView) {
            super(itemView);
            examNameDisplay = itemView.findViewById(R.id.exam_name_display);
            examDateDisplay = itemView.findViewById(R.id.exam_date_display);
            examTimeDisplay = itemView.findViewById(R.id.exam_time_display);
            examLocationDisplay = itemView.findViewById(R.id.exam_location_display);
        }

        public void bindExam(Exam exam) {
            examNameDisplay.setText(exam.getName());
        }
    }

    private static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView taskDisplay;

        public TaskViewHolder(View itemView) {
            super(itemView);
            taskDisplay = itemView.findViewById(R.id.task_display);
        }

        public void bindTask(Todo todo) {
            taskDisplay.setText(todo.getName());
        }
    }

    private static class AssignmentViewHolder extends RecyclerView.ViewHolder {
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
            assignDue.setText(assignment.getDue().toString());
        }
    }
}
