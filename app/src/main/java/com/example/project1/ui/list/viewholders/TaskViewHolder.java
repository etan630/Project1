package com.example.project1.ui.list.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;

import com.example.project1.NavGraphDirections;
import com.example.project1.R;
import com.example.project1.data.list.ListItem;
import com.example.project1.data.list.Todo;
import com.example.project1.viewmodel.AbstractAppViewModel;

public class TaskViewHolder extends AbstractListViewHolder {
    private final TextView taskDisplay;

    public TaskViewHolder(View itemView, AbstractAppViewModel viewModel, NavController navController) {
        super(itemView, viewModel, navController);

        taskDisplay = itemView.findViewById(R.id.task_display);
    }

    @Override
    public void populateView(ListItem listItem) {
        Todo todo = (Todo) listItem;

        taskDisplay.setText(todo.getName());
    }

    @Override
    protected View.OnClickListener onEdit(NavController controller) {
        return buttonView -> {
            NavGraphDirections.ActionGlobalAddTodoFragment action = NavGraphDirections.actionGlobalAddTodoFragment();
            action.setTodoId(boundItem.getId());

            controller.navigate(action);
        };
    }
}
