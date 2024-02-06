package com.example.project1.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.viewmodel.AbstractAppViewModel;

import java.util.List;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseViewHolder> {
    private AbstractAppViewModel viewModel;
    private List<Course> courses;

    public CourseListAdapter(AbstractAppViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_course_card, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = viewModel.getCourses().getValue().get(position);
        holder.classNameTextView.setText(course.getName());
        holder.instructorTextView.setText(course.getInstructor());
        holder.timeTextView.setText(course.getTime());
        holder.sectionTextView.setText(course.getSection());
        holder.buildingTextView.setText(course.getLocation());
        holder.roomTextView.setText(course.getRoomNumber());

        holder.delete.setOnClickListener(view -> {
            courses.remove(position);
            notifyDataSetChanged();
        });
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return viewModel.getCourses().getValue().size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        public TextView classNameTextView;
        public TextView instructorTextView;
        public TextView timeTextView;
        public TextView sectionTextView;
        public TextView buildingTextView;
        public TextView roomTextView;

        private ImageButton delete;

        public CourseViewHolder(View itemView) {
            super(itemView);
            classNameTextView = itemView.findViewById(R.id.class_name_input);
            instructorTextView = itemView.findViewById(R.id.instructor_input);
            timeTextView = itemView.findViewById(R.id.time_input);
            sectionTextView = itemView.findViewById(R.id.section_input);
            buildingTextView = itemView.findViewById(R.id.building_input);
            roomTextView = itemView.findViewById(R.id.room_input);

            delete = itemView.findViewById(R.id.delete_button);


        }
    }
}


//
//    // Override the getView method to customize the appearance of each item in the ListView
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        // Inflate the course_list_item layout if convertView is null
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_courses, parent, false);
//        }
//
//        //click listeners for delete
//        Button deleteButton = convertView.findViewById(R.id.delete_button);
//        deleteButton.setOnClickListener(v -> showDeleteConfirmation(courses.get(position)));
//
//        // Return the updated convertView
//        return convertView;
//    }
//
//    // Add a method to update the list of courses
//
//    private void showDeleteConfirmation(Course course) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        builder.setTitle("Delete Course");
//        builder.setMessage("Are you sure you want to delete this course " + course.getName() + "?");
//        builder.setPositiveButton("Yes", (dialog, which) -> deleteCourse(course));
//        builder.setNegativeButton("No", null);
//        builder.show();
//    }
//
//    private void deleteCourse(Course course) {
//        courses.remove(course);
//        AppViewModel viewModel = new ViewModelProvider((FragmentActivity) context).get(AppViewModel.class);
//        viewModel.removeCourse(course);
//    }
