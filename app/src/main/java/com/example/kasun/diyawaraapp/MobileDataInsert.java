package com.example.kasun.diyawaraapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MobileDataInsert extends Activity {

    EditText Location,Waterlevel,Velocity,Anyotherdata,Imergency;
    String location,waterlevel,velocity,anyotherdata,imergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_data_insert);
        Location = (EditText)findViewById(R.id.et_location);
        Waterlevel = (EditText)findViewById(R.id.et_waterlevel);
        Velocity = (EditText)findViewById(R.id.et_velocity);
        Anyotherdata = (EditText)findViewById(R.id.et_anyotherdata);
        Imergency = (EditText)findViewById(R.id.et_imergency);

    }


    public void insertRealTimeData(View view)
    {

        location = Location.getText().toString();
        waterlevel = Waterlevel.getText().toString();
        velocity = Velocity.getText().toString();
        anyotherdata = Anyotherdata.getText().toString();
        imergency = Imergency.getText().toString();

        BackgroundTask backgroundTask = new BackgroundTask();
        backgroundTask.execute(location,waterlevel,velocity,anyotherdata,imergency);
        finish();

    }

    class BackgroundTask extends AsyncTask<String,Void,String>
    {
        String insertdata_url;

        @Override
        protected void onPreExecute() {
            insertdata_url = "http://kas90dan.comli.com/insertdata.php";
        }

        @Override
        protected String doInBackground(String... args) {

            String location,waterlevel,velocity,anyotherdata,imergency;

            location = args[0];
            waterlevel = args[1];
            velocity = args[2];
            anyotherdata = args[3];
            imergency = args[4];

            try {
                URL url = new URL(insertdata_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));


        String data_string = URLEncoder.encode("location","UTF-8")+"="+URLEncoder.encode(location,"UTF-8")+"&"+
                URLEncoder.encode("waterlevel","UTF-8")+"="+URLEncoder.encode(waterlevel,"UTF-8")+"&"+
                URLEncoder.encode("velocity","UTF-8")+"="+URLEncoder.encode(velocity,"UTF-8")+"&"+
                URLEncoder.encode("anyotherdata","UTF-8")+"="+URLEncoder.encode(anyotherdata,"UTF-8")+"&"+
                URLEncoder.encode("imergency","UTF-8")+"="+URLEncoder.encode(imergency,"UTF-8");

                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();
                return " One Row of Data Inserted.....";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
        }
    }
    }


