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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoadActivityFragment extends Fragment {
    private TextView textCountdown;
    public CountDownTimer counter;
    private Bundle extras;
    private InterstitialAd interstitialAd;

    public LoadActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         extras = getActivity().getIntent().getExtras();

        View rootView = inflater.inflate(R.layout.fragment_load, container, false);
        textCountdown = (TextView) rootView.findViewById(R.id.text_load);
        Button b = (Button) rootView.findViewById(R.id.button_load_web);

        interstitialAd = new InterstitialAd(getContext());
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                cancelTimer();
                skipThis();
            }
        });

        requestNewInterstitial();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }else{
                    Toast.makeText(getContext(), "See ad's" , Toast.LENGTH_SHORT).show();
                    cancelTimer();
                    skipThis();
                }
            }
        });

        timerCount();

        return rootView;
    }

    public void requestNewInterstitial(){
        AdRequest adIntRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        interstitialAd.loadAd(adIntRequest);
    }

    public boolean timerCount(){
        counter = new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                textCountdown.setText("" + millisUntilFinished / 1000);
            }

        public void onFinish() {
            if(interstitialAd.isLoaded()){
                interstitialAd.show();
            }else {
                textCountdown.setText("done!");
                skipThis();
            }
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
