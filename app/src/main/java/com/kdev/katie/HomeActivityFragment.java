package com.kdev.katie;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {
    private WebView myWebView;
    private Resources res;
    private static String[] socialApps;
    private static String[] socialWebs;

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
        myWebView= (WebView) rootWebView.findViewById(R.id.webview_home);

        GridView gridView = (GridView) rootView.findViewById(R.id.gridview_home);
        gridView.setAdapter(new ImageAdapter(getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                auxGrid(position);
            }
        });

        return rootView;
    }

    public void auxGrid(int position){
        Toast.makeText(getContext(), socialApps[position] , Toast.LENGTH_SHORT).show();
//        Debe ser usado en telefono y no en simulador ???
//        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(socialWebs[position]);
    }
}
