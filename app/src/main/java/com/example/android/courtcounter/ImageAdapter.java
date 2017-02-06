package com.example.android.courtcounter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;

/**
 * Created by Reggie on 06-Feb-17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return teamLogos.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageButton for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageButton btn;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            btn = new ImageButton(mContext);
            btn.setLayoutParams(new GridView.LayoutParams(110, 110));
            btn.setScaleType(ImageButton.ScaleType.CENTER_CROP);
            btn.setPadding(3, 3, 3, 3);
        } else {
            btn = (ImageButton) convertView;
        }

        btn.setImageResource(teamLogos[position]);
        btn.setBackgroundColor(0);
        return btn;
    }

    //Array of references to drawable team logos
    private Integer[] teamLogos = {
            R.drawable.logo1, R.drawable.logo2, R.drawable.logo3, R.drawable.logo4,
            R.drawable.logo5, R.drawable.logo6, R.drawable.logo7, R.drawable.logo8,
            R.drawable.logo9, R.drawable.logo10, R.drawable.logo11, R.drawable.logo12,
            R.drawable.logo13, R.drawable.logo14, R.drawable.logo15, R.drawable.logo16,
            R.drawable.logo17, R.drawable.logo18, R.drawable.logo19, R.drawable.logo20,
            R.drawable.logo21, R.drawable.logo22, R.drawable.logo22, R.drawable.logo24,
            R.drawable.logo25, R.drawable.logo26, R.drawable.logo27, R.drawable.logo28,
            R.drawable.logo29, R.drawable.logo30
    };

    //Initialise an array of NBA teams.
    String teams[] = {
            "Atlanta Hawks", "Boston Celtics", "Brooklyn Nets", "Charlotte Hornets",
            "Chicago Bulls", "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets",
            "Detroit Pistons", "Golden State Warriors", "Houston Rockets", "Indiana Pacers",
            "LA Clippers", "LA Lakers", "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks",
            "Minnesota Timberwolves", "New Orleans Pelicans", "New York Knicks",
            "Oklahoma City Thunder", "Orlando Magic", "Philadelphia 76ers", "Phoenix Suns",
            "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors",
            "Utah Jazz", "Washington Wizards"
    };
}
