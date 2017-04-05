package com.kdev.katie;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class LoadActivity extends AppCompatActivity {
    private ProgressBar spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);


        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            spinner = (ProgressBar)findViewById(R.id.progressBar);
            spinner.getIndeterminateDrawable().setColorFilter(
                    getResources().getColor(R.color.colorPrimaryDark),
                    android.graphics.PorterDuff.Mode.MULTIPLY);
        }


    }


}
