package com.example.akshat.attendence;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
//import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;

//@SuppressLint("NewApi")
public class Splash extends AppCompatActivity {

    //@TargetApi(Build.VERSION_CODES.HONEYCOMB)
    //@SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Thread t =new Thread(){
            public void run(){
                try{
                    sleep(10000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent i =new Intent(Splash.this,HomeActivity.class);
                    startActivity(i);
                }
            }
        };
        t.start();
    }
    @Override
    public void onPause(){
        super.onPause();
        finish();
    }

}