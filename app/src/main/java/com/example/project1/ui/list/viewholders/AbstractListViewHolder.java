package com.example.project1.ui.list.viewholders;

import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.data.list.ListItem;
import com.example.project1.viewmodel.AbstractAppViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class AbstractListViewHolder extends RecyclerView.ViewHolder {
    private AbstractAppViewModel viewModel;
    protected ListItem boundItem;

    private final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());

    public AbstractListViewHolder(@NonNull View itemView, AbstractAppViewModel viewModel, NavController navController) {
        super(itemView);

        this.viewModel = viewModel;

        ImageButton button = itemView.findViewById(R.id.edit_button);
        button.setOnClickListener(onEdit(navController));

        ImageButton delete = itemView.findViewById(R.id.delete_button);
        delete.setOnClickListener(onDelete());
    }

    public void bindTo(ListItem listItem) {
        this.boundItem = listItem;

        populateView(listItem);
    }

    /**
     * Uses the given list item instance to populate the visuals of the held view.
     * @param listItem
     */
    public abstract void populateView(ListItem listItem);

    protected View.OnClickListener onEdit(NavController controller) {
        return null;
    }

    protected View.OnClickListener onDelete() {
        return buttonView -> {
            if (boundItem != null) {
                this.viewModel.removeListItem(this.boundItem);
            }
        };
    }

    protected String formatDate(Date date) {
        return dateFormat.format(date);
    }
}
