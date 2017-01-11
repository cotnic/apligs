package com.example.nacepc.apligs;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private final String serviceName = "http://localhost:8080/apligs-rest/v1/sporocila/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void funkcijaLogIN(View view) {
        AsyncPovezavaTask neki = new AsyncPovezavaTask();
        neki.execute((Void)null);


    }

    public void funkcijaRegistracija(View view) {
        AsyncPovezava2Task neki = new AsyncPovezava2Task();
        neki.execute((Void)null);


    }
    public class AsyncPovezavaTask extends AsyncTask<Void, Void, Void> {
        String neki2 = "http://10.0.2.2:8080/apligs-rest/v1/sporocila/";
        Context context;
        String neki="";
        @Override
        protected Void doInBackground(Void... params) {
            try {
                System.out.println(neki2);
                neki = Connections.getConnection(neki2);
            } catch (IOException e) {
                neki = "";

                e.printStackTrace();
            } catch (RuntimeException e) {
                neki = "";
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if(neki.length()<80) {
                Toast.makeText(MainActivity.this, "Dostop do streznika ni mogoc", Toast.LENGTH_LONG).show();

            }else{
                Intent a = new Intent();
                a.setClass(getApplicationContext(), LogInActivity.class);
                startActivity(a);
            }


        }
    }
    public class AsyncPovezava2Task extends AsyncTask<Void, Void, Void> {
        String neki2 = "http://10.0.2.2:8080/apligs-rest/v1/sporocila/";
        Context context;
        String neki="";
        @Override
        protected Void doInBackground(Void... params) {
            try {
                System.out.println(neki2);
                neki = Connections.getConnection(neki2);
            } catch (IOException e) {
                neki = "";
                e.printStackTrace();
            } catch (RuntimeException e) {
                neki = "";

            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if(neki.length()<80){
                Toast.makeText(MainActivity.this, "Dostop do streznika ni mogoc", Toast.LENGTH_LONG).show();
            }else{
                Intent a = new Intent();
                a.setClass(getApplicationContext(),RegisterAcitivty.class);
                startActivity(a);
            }


        }
    }
}
