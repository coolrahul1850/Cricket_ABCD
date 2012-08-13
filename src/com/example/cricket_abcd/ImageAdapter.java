package com.example.cricket_abcd;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    static public String Switch; 

    public ImageAdapter(Context c) {
        mContext = c;
        if (c.toString().contains("Main"))
        {
        	Switch = "Main";
        }
        else if (c.toString().contains("Batting"))
        {
        	Switch = "Batting";
        }
        Log.d(c.toString(),"The class that was entereed");
    }

   
	public int getCount() {
		
		if (Switch =="Main")
			return mThumbIds1.length;
		else if (Switch =="Batting")
			return mThumbIds.length;
		else
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
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

       if (Switch.contains("Main"))
        {
        	imageView.setImageResource(mThumbIds1[position]);

        }
        else if (Switch.contains("Batting"))
        {
        	imageView.setImageResource(mThumbIds[position]);
        }
                
        return imageView;
    }

  
    
  // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_2,R.drawable.sample_2
    };

    private Integer[] mThumbIds1 = {
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3
    };
	
}