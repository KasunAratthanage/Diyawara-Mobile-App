package com.example.kasun.diyawaraapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManningCalculation extends Activity {
    Button B1,B2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manning_calculation);

        B1=(Button)findViewById(R.id.btretrive);
        B2=(Button)findViewById(R.id.btinsert);
        textView = (TextView)findViewById(R.id.textView7);

        ConnectivityManager connectivityManager= (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isConnected())
        {
            textView.setSystemUiVisibility(View.VISIBLE);
        }

        else
        {
            B1.setEnabled(false);
            B2.setEnabled(false);

        }
    }


    public void insertRealTimeData(View view)
    {
        startActivity(new Intent(this, MobileDataInsert.class));
    }

    public void googleMap(View view)
    {
        startActivity(new Intent(this,MapsActivity.class));
    }

    public void getjsonData(View view)
    {
        startActivity(new Intent(this,GetDataFromDatabase.class));
    }
}
