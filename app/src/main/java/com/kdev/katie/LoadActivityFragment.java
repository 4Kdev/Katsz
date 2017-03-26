package com.kdev.katie;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoadActivityFragment extends Fragment {
    private TextView textCountdown;
    public CountDownTimer counter;
    private Bundle extras;

    public LoadActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         extras = getActivity().getIntent().getExtras();

        View rootView = inflater.inflate(R.layout.fragment_load, container, false);
        textCountdown = (TextView) rootView.findViewById(R.id.text_load);
        Button b = (Button) rootView.findViewById(R.id.button_load_web);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "See ad's" , Toast.LENGTH_SHORT).show();
                cancelTimer();
                skipThis();
            }
        });

        timerCount();

        return rootView;
    }

    public boolean timerCount(){
        counter = new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                textCountdown.setText("" + millisUntilFinished / 1000);
            }

        public void onFinish() {
            textCountdown.setText("done!");
            skipThis();
        }
        }.start();
        return false;
    }

    public void cancelTimer(){
        counter.cancel();
    }

    public void skipThis(){
        Intent i = new Intent(getContext(), WebActivity.class);
        i.putExtras(extras);
        startActivity(i);
    }
}
