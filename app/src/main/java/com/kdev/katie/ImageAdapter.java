package com.kdev.katie;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jorge alberto on 13/02/2017.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Resources res;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        res = mContext.getResources();
        String[] text_icon = res.getStringArray(R.array.social_app);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.icon_spec, parent, false);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.imageView);
        TextView text = (TextView) convertView.findViewById(R.id.textView2);
        icon.setImageResource(mThumbIds[position]);
        text.setText(text_icon[position]);

        return convertView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.icontestblogspot,
            R.drawable.icontestdropbox,
            R.drawable.icontestfacebook,
            R.drawable.icontestflickr,
            R.drawable.icontestgithub,
            R.drawable.icontestgoogle,
            R.drawable.icontestinstagram,
            R.drawable.icontestlinkedin,
            R.drawable.icontestpinterest,
            R.drawable.icontestreddit,
            R.drawable.icontestswarm,
            R.drawable.icontesttumblr,
            R.drawable.icontesttwitter,
            R.drawable.icontestvine,
            R.drawable.icontestyoutube,
    };
}


