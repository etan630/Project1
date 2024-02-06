package com.example.project1.ui.list.viewholders;

import android.view.View;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.data.list.Exam;
import com.example.project1.data.list.ListItem;
import com.example.project1.viewmodel.AbstractAppViewModel;

public class ExamViewHolder extends AbstractListViewHolder {
    private final TextView examNameDisplay, examDateDisplay, examTimeDisplay, examLocationDisplay;

    public ExamViewHolder(View itemView, AbstractAppViewModel viewModel) {
        super(itemView, viewModel);

        examNameDisplay = itemView.findViewById(R.id.exam_name_display);
        examDateDisplay = itemView.findViewById(R.id.exam_date_display);
        examTimeDisplay = itemView.findViewById(R.id.exam_time_display);
        examLocationDisplay = itemView.findViewById(R.id.exam_location_display);
    }

    @Override
    public void populateView(ListItem listItem) {
        Exam exam = (Exam) listItem;

        examNameDisplay.setText(exam.getName());
        examDateDisplay.setText(formatDate(exam.getDue()));
        examTimeDisplay.setText(exam.getTime());
        examLocationDisplay.setText(exam.getLocation());
    }
}
