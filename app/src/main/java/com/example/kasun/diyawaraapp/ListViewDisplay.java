package com.example.kasun.diyawaraapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListViewDisplay extends AppCompatActivity {

    String json_string;
    JSONObject jsonobject;
    JSONArray jsonarray;
    ContactAdapter contactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView)findViewById(R.id.listview);

        contactAdapter = new ContactAdapter(this,R.layout.row_layout);

        listView.setAdapter(contactAdapter);

        json_string = getIntent().getExtras().getString("json_data");

        try {
            jsonobject = new JSONObject(json_string);
           jsonarray = jsonobject.getJSONArray("server_response");
            int count = 0;
            String location,waterlevel,velocity,anyotherdata,imergency;


            while(count<jsonobject.length())
            {
                JSONObject JO = jsonarray.getJSONObject(count);

                location =JO.getString("location");
                waterlevel=JO.getString("waterlevel");
                velocity=JO.getString("velocity");
                anyotherdata=JO.getString("anyotherdata");
                imergency=JO.getString("imergency");

                Contacts contacts = new Contacts(location,waterlevel,velocity,anyotherdata,imergency);

                contactAdapter.add(contacts);
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
