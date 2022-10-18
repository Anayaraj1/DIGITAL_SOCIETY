package com.example.digitalsocity_new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
        DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NavigationView nav_view = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.opne,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Toolbar toolbar = findViewById(R.id.tollbarss);
        setSupportActionBar(toolbar);




        nav_view.setNavigationItemSelectedListener(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        if (savedInstanceState ==null)
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view,new MyprofileFragment())
                    .commit();
            nav_view.setCheckedItem(R.id.myprofileFragment);
        }



    }

    public void onBackPressed()
    {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.myprofileFragment:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view,new MyprofileFragment())
                .commit();
                break;

            case R.id.memberRequestFragment:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view,new MemberRequestFragment())
                            .commit();
                break;
            case R.id.complaintsFragment:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view,new ComplaintsFragment())
                        .commit();
                break;

            case R.id.noticeFragment:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view,new NoticeFragment())
                        .commit();
                break;

            case R.id.eventsFragment:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view,new EventsFragment())
                        .commit();
                break;

            case R.id.logoutFragment:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view,new LogoutFragment())
                        .commit();
                break;

        }
        return true;
    }

}