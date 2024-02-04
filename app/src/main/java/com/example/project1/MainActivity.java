package com.example.project1;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupMenu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final List<Integer> SHOW_NAVBAR_ON =
            Arrays.asList(R.id.coursesFragment, R.id.listFragment);

    private NavController navController;

    private FloatingActionButton addButton;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        AppViewModel viewModel = new ViewModelProvider(this).get(AppViewModel.class);

        setContentView(R.layout.main_activity);

        // get navcontroller
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        this.navController = navHostFragment.getNavController();

        // activate navigation bar
        this.bottomNav = findViewById(R.id.nav_fragment);
        bottomNav.setOnItemSelectedListener(navBarListener);

        // activate add button
        this.addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(addButtonListener);

        // only show navbar & plus button on some screens
        this.navController.addOnDestinationChangedListener(destChangedListener);
    }

    private final NavigationBarView.OnItemSelectedListener navBarListener = item -> {
        int itemId = item.getItemId();
        if (itemId == R.id.courses) {
            // nav to courses
            navController.navigate(R.id.coursesFragment);
        } else {
            // nav to list
            navController.navigate(R.id.listFragment);
        }
        return true;
    };

    private final View.OnClickListener addButtonListener = v -> {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, addButton,
                Gravity.TOP | Gravity.END);

        popupMenu.getMenuInflater().inflate(R.menu.addmenu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem -> {
            if (menuItem.getItemId() == R.id.item_addcourse) {
                NavGraphDirections.ActionGlobalAddCourseFragment action = NavGraphDirections.actionGlobalAddCourseFragment();
                navController.navigate(action);
            } else if (menuItem.getItemId() == R.id.item_addassignment) {
                NavGraphDirections.ActionGlobalAddAssignmentFragment action = NavGraphDirections.actionGlobalAddAssignmentFragment();
                navController.navigate(action);
            } else if (menuItem.getItemId() == R.id.item_addexam) {
                NavGraphDirections.ActionGlobalAddExamFragment action = NavGraphDirections.actionGlobalAddExamFragment();
                navController.navigate(action);
            } else if (menuItem.getItemId() == R.id.item_addtodo) {
                NavGraphDirections.ActionGlobalAddTodoFragment action = NavGraphDirections.actionGlobalAddTodoFragment();
                navController.navigate(action);
            }

            return true;
        });

        popupMenu.show();
    };

    private final NavController.OnDestinationChangedListener destChangedListener =
            (NavController controller, NavDestination dest, Bundle args) -> {
                if (SHOW_NAVBAR_ON.contains(dest.getId())) {
                    this.bottomNav.setVisibility(View.VISIBLE);
                    this.addButton.setVisibility(View.VISIBLE);
                } else {
                    this.bottomNav.setVisibility(View.GONE);
                    this.addButton.setVisibility(View.GONE);
                }
            };

}
