package com.example.project1.ui.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.project1.R;
import com.example.project1.viewmodel.AbstractAppViewModel;
import com.example.project1.viewmodel.NoDBAppViewModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A screen with a back button, an "add" button, and a placeholder for custom
 * implementation-specific form content.
 */
public abstract class AbstractAddFragment extends Fragment {
    protected AbstractAppViewModel viewModel;
    protected final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());

    /**
     * Gets the id of the View (typically a form with text inputs) to be inserted into this add
     * screen. Should be overriden.
     *
     * @return id of form view
     */
    protected int getFormContent() {
        return 0;
    }

    /**
     * Logic to be run when the add button on the add screen is clicked.
     *
     * @param thisFragment  this fragment's view
     * @param navController the nav controller to use to navigate away from this screen
     * @return OnCLickListener
     */
    protected abstract View.OnClickListener onAdd(View thisFragment, NavController navController);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(NoDBAppViewModel.class);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_dialogue, container, false);

        activateNavButtons(view);

        // insert implementation-specific form content
        if (getFormContent() != 0) {
            inflater.inflate(getFormContent(), view.findViewById(R.id.form_placeholder));
        }

        return view;
    }

    public Date parseDate(String str) {
        Date parsed;
        try {
            parsed = dateFormat.parse(str);
            return parsed;
        } catch (ParseException e) {
            Toast toast = Toast.makeText(getActivity(), "Invalid date.", Toast.LENGTH_SHORT);
            toast.show();

            return null;
        }
    }

    private void activateNavButtons(View view) {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        Button backButton = view.findViewById(R.id.btn_back);
        backButton.setOnClickListener(v -> {
            navController.popBackStack();
        });

        Button addButton = view.findViewById(R.id.btn_add);
        addButton.setOnClickListener(onAdd(view, navController));
    }
}
