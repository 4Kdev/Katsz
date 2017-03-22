package com.kdev.katie;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(uiOptions);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_back);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                onBackPressed();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab_close);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                finishAffinity();
            }
        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /**
         * Hay que traer la posicion de la main activity
         */
        res = this.getResources();
        String[] webPages = res.getStringArray(R.array.social_web);

        WebView webV = (WebView) findViewById(R.id.webView);
        //Copied
        webV.getSettings().setJavaScriptEnabled(true);
        webV.getSettings().setLoadsImagesAutomatically(true);
        webV.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webV.getSettings().setAppCacheEnabled(false);
        webV.getSettings().setLoadWithOverviewMode(true);
        webV.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webV.setScrollbarFadingEnabled(false);

        webV.setWebViewClient(new WebViewClient());
        webV.loadUrl(webPages[0]);

    }

}
