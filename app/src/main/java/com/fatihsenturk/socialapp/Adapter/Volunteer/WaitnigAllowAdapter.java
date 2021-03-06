package com.fatihsenturk.socialapp.Adapter.Volunteer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fatihsenturk.socialapp.Model.StuffModel;
import com.fatihsenturk.socialapp.R;
import com.fatihsenturk.socialapp.Utils.Helper;
import com.fatihsenturk.socialapp.Utils.Utils;

import java.util.List;
import java.util.TooManyListenersException;

/**
 * Created by TOSHIBA on 19.3.2016. Mart
 * Dont worry !
 */
public class WaitnigAllowAdapter extends BaseAdapter {
    private List<StuffModel> myStuffList ;
    private final Activity activity;



    public WaitnigAllowAdapter(Activity activity, List<StuffModel> myStuffList){
        this.activity = activity;
        this.myStuffList = myStuffList;
    }

    @Override
    public int getCount() {

        if (myStuffList == null){
            return 0;
        }else {
            return myStuffList.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return myStuffList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View cell = convertView;

        if (cell ==  null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cell = inflater.inflate(R.layout.item_row, parent, false);
            Toast.makeText(activity, "iceri girdi", Toast.LENGTH_LONG).show();
        }

        Toast.makeText(activity, "iceri girMEdi", Toast.LENGTH_LONG).show();


        NewsRowHolder newsRowHolder = new NewsRowHolder();
        init(cell,newsRowHolder);
        setView(position, newsRowHolder);

        return cell;
    }


    private static class NewsRowHolder {
        private ImageView newsImage;
        private TextView newsDate;
        private TextView newsTitle;
        private TextView newsDescription;
        private LinearLayout newsBackground;
    }

    private void init(View view, NewsRowHolder viewHolder) {
        viewHolder.newsImage = (ImageView) view.findViewById(R.id.news_row_photo);
        viewHolder.newsDate = (TextView) view.findViewById(R.id.news_row_date);
        viewHolder.newsTitle = (TextView) view.findViewById(R.id.news_row_title);
        viewHolder.newsDescription = (TextView)view.findViewById(R.id.news_row_description);
        viewHolder.newsBackground = (LinearLayout) view.findViewById(R.id.news_row_layout);

    }

    private void setView(int position, NewsRowHolder viewHolder) {
        StuffModel news =  myStuffList.get(position);
        viewHolder.newsDate.setText("kac y,l,");
        viewHolder.newsTitle.setText("test");
//        viewHolder.newsDescription.setText("ali burdan gecti");

        if (position % 2 == 0) {
            viewHolder.newsBackground.setBackgroundColor(ContextCompat.getColor(activity, R.color.item_color_1));
        } else {
            viewHolder.newsBackground.setBackgroundColor(ContextCompat.getColor(activity, R.color.item_color_2));
        }

    }




}
