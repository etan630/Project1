package com.example.project1.data;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.viewmodel.AbstractAppViewModel;

import java.util.ArrayList;
import java.util.List;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseViewHolder> {
    private AbstractAppViewModel viewModel;
    private List<Course> courses;
    private Context context;

    public CourseListAdapter(AbstractAppViewModel viewModel, Context context) {
        this.viewModel = viewModel;
        this.context = context;
        this.courses = new ArrayList<>();
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_course_card, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        List<Course> courses = viewModel.getCourses().getValue();
        if (courses != null && position < courses.size()) {
            Course course = courses.get(position);
            holder.classNameTextView.setText(course.getName());
            holder.instructorTextView.setText(course.getInstructor());
            holder.timeTextView.setText(course.getTime());
            holder.sectionTextView.setText(course.getSection());
            holder.buildingTextView.setText(course.getLocation());
            holder.roomTextView.setText(course.getRoomNumber());
            holder.daysOfWeekTextView.setText(course.getDays());

            holder.delete.setOnClickListener(view -> {
                showDeleteConfirmation(course, position);
            });
        }
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        notifyDataSetChanged();
    }

    private void showDeleteConfirmation(Course course, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete Course");
        builder.setMessage("Are you sure you want to delete this course " + course.getName() + "?");
        builder.setPositiveButton("Yes", (dialog, which) -> deleteCourse(position));
        builder.setNegativeButton("No", null);
        builder.show();
    }

    private void deleteCourse(int position) {
        courses.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        List<Course> courses = viewModel.getCourses().getValue();
        return courses != null ? courses.size() : 0;
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        public TextView classNameTextView;
        public TextView instructorTextView;
        public TextView timeTextView;
        public TextView sectionTextView;
        public TextView buildingTextView;
        public TextView roomTextView;
        public TextView daysOfWeekTextView;

        private ImageButton delete;

        public CourseViewHolder(View itemView) {
            super(itemView);
            classNameTextView = itemView.findViewById(R.id.class_name_input);
            instructorTextView = itemView.findViewById(R.id.instructor_input);
            timeTextView = itemView.findViewById(R.id.time_input);
            sectionTextView = itemView.findViewById(R.id.section_input);
            buildingTextView = itemView.findViewById(R.id.building_input);
            roomTextView = itemView.findViewById(R.id.room_input);
            daysOfWeekTextView = itemView.findViewById(R.id.day_of_week_input);

            delete = itemView.findViewById(R.id.delete_button);
        }
    }
}
