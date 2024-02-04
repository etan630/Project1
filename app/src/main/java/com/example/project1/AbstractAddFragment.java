package com.example.project1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.project1.viewmodel.AppViewModel;

/**
 * A screen with a back button, an "add" button, and a placeholder for custom
 * implementation-specific form content.
 */
public abstract class AbstractAddFragment extends Fragment {
    protected AppViewModel viewModel;

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
     * Logic to be run after the form content is inflated from XML, e.g. to activate elements.
     *
     * @param thisFragment this fragment's view
     */
    protected void afterInflating(View thisFragment) {
    }

    ;

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
        viewModel = new ViewModelProvider(getActivity()).get(AppViewModel.class);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_dialogue, container, false);

        activateNavButtons(view);

        // insert implementation-specific form content
        if (getFormContent() != 0) {
            inflater.inflate(getFormContent(), view.findViewById(R.id.form_placeholder));
        }
        afterInflating(view);

        return view;
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
