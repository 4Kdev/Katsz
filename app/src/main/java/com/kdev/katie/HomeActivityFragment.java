package com.kdev.katie;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
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
//                switch (position){
//                    case 0:
//                        Toast.makeText(getContext(), socialApps[0] , Toast.LENGTH_SHORT).show();
////                        loadview(position);
//                        break;
//                    case 1:
//                        Toast.makeText(getContext(), "Google" , Toast.LENGTH_SHORT).show();
////                        loadview(position);
//                        break;
//                    case 2:
//                        Toast.makeText(getContext(), "Instagram" , Toast.LENGTH_SHORT).show();
////                        loadview(position);
//                        break;
//                    case 3:
//                        Toast.makeText(getContext(), "Pinterest" , Toast.LENGTH_SHORT).show();
////                        loadview(position);
//                        break;
//                    case 4:
//                        Toast.makeText(getContext(), "Skype" , Toast.LENGTH_SHORT).show();
////                        loadview(position);
//                        break;
//                    case 5:
//                        Toast.makeText(getContext(), "Twitter" , Toast.LENGTH_SHORT).show();
////                        loadview(position);
//                        break;
//                    default:
//                        Toast.makeText(getContext(), "Error ?" , Toast.LENGTH_SHORT).show();
////                        loadview(position);
//                        break;
//                }
                auxGrid(position);
            }
        });

        return rootView;
    }

    public void loadview(int reference){
        switch (reference){
            case 0:
                myWebView.loadUrl("http://www.facebook.com");
                return;
            case 1:
                myWebView.loadUrl("http://www.google.com");
                return;
            case 2:
                myWebView.loadUrl("http://www.instagram.com");
                return;
            case 3:
                myWebView.loadUrl("http://www.pinterest.com");
                return;
            case 4:
                myWebView.loadUrl("http://www.skype.com");
                return;
            case 5:
                myWebView.loadUrl("http://www.twitter.com");
                return;
            default:
                return;

        }

    }

    public void auxGrid(int position){
        Toast.makeText(getContext(), socialApps[position] , Toast.LENGTH_SHORT).show();
        myWebView.loadUrl(socialWebs[position]);
    }
}
