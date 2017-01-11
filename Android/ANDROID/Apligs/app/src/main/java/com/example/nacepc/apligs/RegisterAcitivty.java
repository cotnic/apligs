package com.example.nacepc.apligs;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

public class RegisterAcitivty extends AppCompatActivity {
    EditText mail;
    EditText geslo;
    EditText ime;
    EditText priimek;
    EditText instrument;
    EditText postna;
    EditText mesto;
    JSONObject obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_acitivty);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void funkcijaRegistriraj(View view) {
        mail = (EditText) findViewById(R.id.etMailReq);
        String mail1 = mail.getText().toString();

        geslo = (EditText) findViewById(R.id.etPassReq);
        String geslo1 = geslo.getText().toString();

        ime = (EditText) findViewById(R.id.etImeReq);
        String ime1 = ime.getText().toString();

        priimek = (EditText) findViewById(R.id.etPriimekReq);
        String priimek1 = priimek.getText().toString();

        instrument = (EditText) findViewById(R.id.etInstrumentReq);
        String instrument1 = instrument.getText().toString();

        postna = (EditText) findViewById(R.id.etPostnaReq);
        String postna1 = postna.getText().toString();

        mesto = (EditText) findViewById(R.id.etMestoReq);
        String mesto1 = mesto.getText().toString();

        if(mesto1.length()>0  && postna1.length() >0 && ime1.length() >0 && mail1.length() >0 && geslo1.length() >0 && priimek1.length() >0 && instrument1.length()>0){
            obj = new JSONObject();
            try {
                obj.put("upEmail", mail1);
                obj.put("upGeslo", geslo1);
                obj.put("upIme", ime1);
                obj.put("upPriimek", priimek1);
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String date = df.format(Calendar.getInstance().getTime());
                obj.put("upUstvarjen", date);
                obj.put("upPicture", "img/person/spicture.jpg");
                obj.put("lokacija",new JSONObject().put("postnaStevilka", 2000).put("loNaziv", "Maribor"));
                obj.put("vloga",new JSONObject().put("idVloga", 5).put("vlNaziv", "kitarist"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            AsyncRegisterTask neki = new AsyncRegisterTask();
            neki.execute((Void) null);
        }else{
            Toast.makeText(RegisterAcitivty.this, "Vnesite vse podatke", Toast.LENGTH_LONG).show();
        }



    }



    public class AsyncRegisterTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                System.out.println(obj.toString());
                Connections.postConnection("http://10.0.2.2:8080/apligs-rest/v1/uporabniki/", obj);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Toast.makeText(RegisterAcitivty.this, "Registracija uspešna", Toast.LENGTH_LONG).show();
            Intent a = new Intent();
            a.setClass(getApplicationContext(),LogInActivity.class);
            startActivity(a);
        }
    }
}