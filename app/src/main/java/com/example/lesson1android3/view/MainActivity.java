package com.example.lesson1android3.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.lesson1android3.R;
import com.example.lesson1android3.adapter.FragmentAdapter;
import com.example.lesson1android3.ui.favorite.FavoriteFragment;
import com.example.lesson1android3.ui.post.PostFragment;
import com.example.lesson1android3.ui.user.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected BottomNavigationView bottomNavigationView;
    protected ViewPager viewPager;
    protected List<Fragment> fragmentList;

    /**
     * Добрый день, Мой Верный друг в ютубе остановились на 23:00, сюжет - " после создания фрагментов
     * до скорой встречи, милый!!
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onlyCode();

    }

    private void onlyCode() {
        init();
        fillFragment();
        viewPagerSetAdapter();
        bottomNavSetOnNavigation();
    }


    private void bottomNavSetOnNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.action_post)
                    viewPager.setCurrentItem(0);
                else if (item.getItemId() == R.id.action_user)
                    viewPager.setCurrentItem(1);
                else
                    viewPager.setCurrentItem(2);
                return true;
            }
        });
    }

    private void init() {
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        viewPager = findViewById(R.id.viewPager);
        fragmentList = new ArrayList<>();
    }

    private void viewPagerSetAdapter() {
        viewPager.setAdapter(new FragmentAdapter(fragmentList, getSupportFragmentManager()));
        viewPagerSetOnPage();
    }

    private void viewPagerSetOnPage() {
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });
    }

    private void fillFragment() {
        fragmentList.add(new PostFragment());
        fragmentList.add(new UserFragment());
        fragmentList.add(new FavoriteFragment());
    }
}
