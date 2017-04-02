package com.kdev.katie;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {
    private WebView myWebView;
    private Resources res;
    private static String[] socialApps;
    private static String[] socialWebs;
    private ImageButton buttonMsg;
    private AdView adView;

    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        res = getContext().getResources();
        socialApps = res.getStringArray(R.array.social_app);
        socialWebs = res.getStringArray(R.array.social_web);

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        View rootWebView = inflater.inflate(R.layout.web_view, container, false);
        myWebView = (WebView) rootWebView.findViewById(R.id.webview_home);
        buttonMsg = (ImageButton) rootView.findViewById(R.id.button_msg);

        adView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        adView.loadAd(adRequest);

        GridView gridView = (GridView) rootView.findViewById(R.id.gridview_home);
        gridView.setAdapter(new ImageAdapter(getContext()));
        gridView.setFocusable(false);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                auxGrid(position,false);
            }
        });

        buttonMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auxGrid(0,true);
            }
        });

        return rootView;
    }

    public void auxGrid(int position, boolean special){
        if (special) {
            Intent intent = new Intent(getContext(), LoadActivity.class);
            Bundle extras = new Bundle();
            extras.putBoolean("normal_web_app",false);
            intent.putExtras(extras);
            startActivity(intent);
        }else{
            Intent intent = new Intent(getContext(), LoadActivity.class);
            Bundle extras = new Bundle();
            extras.putBoolean("normal_web_app",true);
            extras.putInt("position_list",position);
            intent.putExtras(extras);
            startActivity(intent);
        }
//        Toast.makeText(getContext(), socialApps[position] , Toast.LENGTH_SHORT).show();
////        Debe ser usado en telefono y no en simulador ???
////        myWebView.setWebViewClient(new WebViewClient());
//        myWebView.loadUrl(socialWebs[position]);
    }
}
