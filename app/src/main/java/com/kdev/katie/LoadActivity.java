package com.kdev.katie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoadActivity extends AppCompatActivity {
//    private ProgressBar spinner;
//    private FragmentManager fm;
//    private LoadActivityFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        spinner = (ProgressBar)findViewById(R.id.progressBar);

//        fm = getSupportFragmentManager();
//        fragment = (LoadActivityFragment) fm.findFragmentById(R.id.load_fragment);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "call the other activity", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    public void showProgress(View v){
//        spinner.setVisibility(View.VISIBLE);
//    }

//    public void hideProgress(View v){
//        Toast.makeText(this, "See ad's" , Toast.LENGTH_SHORT).show();
//        fragment.cancelTimer();
//        Intent i = new Intent(this, WebActivity.class);
//        startActivity(i);
//    }
}
