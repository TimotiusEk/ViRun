package com.example.timotiusek.runcompanionvr.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.timotiusek.runcompanionvr.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import fragment.AchievementFragment;
import fragment.PointFragment;
import fragment.ScheduleFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    @BindView(R.id.nav_view__main_act)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout__main_act)
    DrawerLayout drawer;
    @BindView(R.id.toolbar__app_bar_main)
    public Toolbar toolbar;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private ActionBarDrawerToggle toggle;
    public static int currentPoint = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        showTheFirstFragment();

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.setItemIconTintList(null);
        View nvHeader = navigationView.getHeaderView(0);
        CircleImageView civ = (CircleImageView) nvHeader.findViewById(R.id.profile_image__nav_header_main);
        civ.setImageResource(R.drawable.halloween_bg);
        TextView fullname = (TextView) nvHeader.findViewById(R.id.fullname__nav_header_main);
        fullname.setText("Danny Gani");
        TextView position = (TextView) nvHeader.findViewById(R.id.position__nav_header_main);
        position.setText("City Runner");
    }

    private void showTheFirstFragment() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fragment_container__app_bar_main, new PointFragment());
        mFragmentTransaction.commit();
        toolbar.setTitle("Points");
    }

    public void changeFragment(Fragment newFragment) {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fragment_container__app_bar_main, newFragment);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_points) {
            changeFragment(new PointFragment());
        } else if(id == R.id.menu_achievements){
            changeFragment(new AchievementFragment());
        } else if(id == R.id.menu_schedule){
            startActivity(new Intent(this, EventListActivity.class));
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setChecked(int id){
        navigationView.setCheckedItem(id);
    }
}
