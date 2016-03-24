package com.fatihsenturk.socialapp.Fragments.Volunteer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fatihsenturk.socialapp.Adapter.Volunteer.MyStuffAdapter;
import com.fatihsenturk.socialapp.Adapter.Volunteer.WaitnigAllowAdapter;
import com.fatihsenturk.socialapp.Fragments.BaseFragment;
import com.fatihsenturk.socialapp.Model.StuffModel;
import com.fatihsenturk.socialapp.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by TOSHIBA on 19.3.2016. Mart
 * Dont worry !
 */
public class WaitnigAllow extends BaseFragment {

    private List waitinAllowList;
    private WaitnigAllowAdapter waitnigAllowAdapter;
    private String currentUsername;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View mainView = inflater.inflate(R.layout.item_list, container, false);
        ListView listView = (ListView) mainView.findViewById(R.id.item_list);
        FloatingActionButton floatingActionButton = (FloatingActionButton) mainView.findViewById(R.id.add_item_button);

        ParseQuery<StuffModel> stuffModelParseQuery = new ParseQuery<StuffModel>(StuffModel.class);

        ParseUser currentUser = ParseUser.getCurrentUser();
        String username = currentUser.getUsername();
        currentUsername = username;

        stuffModelParseQuery.whereEqualTo("username", username);
        stuffModelParseQuery.whereNotEqualTo("allowStatus", "true");

        stuffModelParseQuery.findInBackground(new FindCallback<StuffModel>() {
            @Override
            public void done(List<StuffModel> list, ParseException e) {
                if (e == null) {
                    waitinAllowList = list;
                }
            }
        });


//        if (waitinAllowList == null){
//            waitnigAllowAdapter = new WaitnigAllowAdapter(getActivity(),null);
//        }else {
//            waitnigAllowAdapter = new WaitnigAllowAdapter(getActivity(), waitinAllowList);
//
//        }

        listView.setAdapter(waitnigAllowAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Do some stuff
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return mainView;
    }
}
