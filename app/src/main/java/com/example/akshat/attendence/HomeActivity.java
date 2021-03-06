package com.example.akshat.attendence;

import android.app.FragmentTransaction;
import  android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import android.os.PersistableBundle;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


import com.google.android.gms.common.api.GoogleApiClient;

public class HomeActivity extends AppCompatActivity
        {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        //fragmentTransaction = getSupportFragmentManager().beginTransaction();
       //fragmentTransaction.add(R.id.main_container, new HomeFragment());



    //       fragmentTransaction.commit();
      navigationView=(NavigationView)findViewById(R.id.navigation_view);

            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    //Intent intent;

                    switch (item.getItemId()) {
                        case R.id.home_id:
                          //  fragmentTransaction=getSupportFragmentManager().beginTransaction();
                           //fragmentTransaction.replace(R.id.main_container,new HomeFragment());

                           Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                            startActivity(intent);
                            //fragmentTransaction.commit();
                            //item.setChecked(true);
                            drawerLayout.closeDrawers();
                            break;

                        case R.id.id_attendance:
                            Intent intent1 = new Intent(HomeActivity.this, MainActivity.class);
                            startActivity(intent1);
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.id_about:
                            Intent intent2 = new Intent(HomeActivity.this, AboutActivity.class);
                            startActivity(intent2);
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.id_link:
                            Intent intent3 = new Intent(HomeActivity.this, LinkActivity.class);
                            startActivity(intent3);
                            drawerLayout.closeDrawers();
                            break;

                    }
                return false;
            }
        });
    }

            @Override
            public void onPostCreate(Bundle savedInstanceState) {
                super.onPostCreate(savedInstanceState);
                actionBarDrawerToggle.syncState();
            }
        }
