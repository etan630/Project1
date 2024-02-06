package com.example.project1.ui.list.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;

import com.example.project1.NavGraphDirections;
import com.example.project1.R;
import com.example.project1.data.list.Assignment;
import com.example.project1.data.list.ListItem;
import com.example.project1.viewmodel.AbstractAppViewModel;

public class AssignmentViewHolder extends AbstractListViewHolder {
    private final TextView assignCourse, assignName, assignDue;

    public AssignmentViewHolder(View itemView, AbstractAppViewModel viewModel, NavController navController) {
        super(itemView, viewModel, navController);

        assignCourse = itemView.findViewById(R.id.assign_course);
        assignName = itemView.findViewById(R.id.assign_name);
        assignDue = itemView.findViewById(R.id.assign_due);
    }

    @Override
    public void populateView(ListItem listItem) {
        Assignment assignment = (Assignment) listItem;

        assignCourse.setText(viewModel.getCourseById(assignment.getAssociatedCourseId()).getName());
        assignName.setText(assignment.getName());
        assignDue.setText(formatDate(assignment.getDue()));
    }

    @Override
    protected View.OnClickListener onEdit(NavController controller) {
        return buttonView -> {
            NavGraphDirections.ActionGlobalAddAssignmentFragment action = NavGraphDirections.actionGlobalAddAssignmentFragment();
            action.setAssignmentId(this.boundItem.getId());

            controller.navigate(action);
        };
    }
}
