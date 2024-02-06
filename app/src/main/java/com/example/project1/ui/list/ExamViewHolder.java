package com.example.project1.ui.list;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.data.list.Exam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class ExamViewHolder extends RecyclerView.ViewHolder {
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
        examDateDisplay.setText(formatDate(exam.getDue()));
        examTimeDisplay.setText(exam.getTime());
        examLocationDisplay.setText(exam.getLocation());
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(date);
    }
}
