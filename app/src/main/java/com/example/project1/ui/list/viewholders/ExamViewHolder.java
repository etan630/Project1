package com.example.project1.ui.list.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;

import com.example.project1.NavGraphDirections;
import com.example.project1.R;
import com.example.project1.data.list.Exam;
import com.example.project1.data.list.ListItem;
import com.example.project1.ui.add.AddExamFragmentDirections;
import com.example.project1.viewmodel.AbstractAppViewModel;

public class ExamViewHolder extends AbstractListViewHolder {
    private final TextView examNameDisplay, examDateDisplay, examTimeDisplay, examLocationDisplay;

    public ExamViewHolder(View itemView, AbstractAppViewModel viewModel, NavController navController) {
        super(itemView, viewModel, navController);

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

    @Override
    protected View.OnClickListener onEdit(NavController controller) {
        return buttonView -> {
            NavGraphDirections.ActionGlobalAddExamFragment action = NavGraphDirections.actionGlobalAddExamFragment();
            action.setExamId(boundItem.getId());

            controller.navigate(action);
        };
    }
}
