package com.kdev.katie;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    private Resources res;
    private int position;
    private boolean specialApp;
    private String urlWeb;
    private String newUA;
    private WebView webV;

    private final Handler mHideHandler = new Handler();
    private static final int UI_ANIMATION_DELAY = 300;

    private View mContentView;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Bundle extras = getIntent().getExtras();
        specialApp = extras.getBoolean("normal_web_app");
        position = extras.getInt("position_list");

        mContentView = getWindow().getDecorView();

        /**
         * Hay que traer la posicion de la main activity
         */
        res = this.getResources();
        String[] webPages = res.getStringArray(R.array.social_web);
        if (specialApp){
            urlWeb = webPages[position];
        }else{
            urlWeb = "http://www.messenger.com";
        }

        webV = (WebView) findViewById(R.id.webView);
        //Copied
        webV.getSettings().setJavaScriptEnabled(true);
        webV.getSettings().setLoadsImagesAutomatically(true);
        webV.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webV.getSettings().setAppCacheEnabled(false);
        webV.getSettings().setLoadWithOverviewMode(true);
        webV.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webV.setScrollbarFadingEnabled(false);

        if (!specialApp){
            newUA = "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
        }else{
            newUA = null;
        }

        webV.getSettings().setUserAgentString(newUA);

        webV.setWebViewClient(new WebViewClient());
        webV.loadUrl(urlWeb);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void UiChangeListener()
    {
        final View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener (new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                    decorView.setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webV.canGoBack()) {
                        webV.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
