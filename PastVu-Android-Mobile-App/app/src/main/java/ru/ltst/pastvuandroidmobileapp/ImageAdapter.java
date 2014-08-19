package ru.ltst.pastvuandroidmobileapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int widthImage, heightImage, margin;

    public ImageAdapter(Context c) {
        mContext = c;
        widthImage = (int)(mContext.getResources().getDisplayMetrics().xdpi*1.5);
        heightImage = (int)(mContext.getResources().getDisplayMetrics().ydpi*1.5);
        margin = 2;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(widthImage, heightImage));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(margin, margin, margin, margin);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.retrika_main,
            R.drawable.retrika_main,
            R.drawable.retrika_main,
            R.drawable.retrika_main,
            R.drawable.retrika_main,
            R.drawable.retrika_main,
            R.drawable.retrika_main,
            R.drawable.retrika_main,
            R.drawable.retrika_main,
            R.drawable.retrika_main,
            R.drawable.retrika_main,
            R.drawable.retrika_main,
            R.drawable.retrika_main
    };
}
