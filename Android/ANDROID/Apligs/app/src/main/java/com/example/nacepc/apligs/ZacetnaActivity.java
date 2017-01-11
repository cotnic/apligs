package com.example.nacepc.apligs;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ZacetnaActivity extends AppCompatActivity {
    TextView tv;
    Uporabnik trenutni =  LogInActivity.trenutnoPrijavljeni;
    public static ArrayList<Sporocilo> sporocila = new ArrayList<Sporocilo>();
    Uporabnik prijUporabnik = LogInActivity.trenutnoPrijavljeni;
    JSONObject jsonObject;
    String jsonpodatki;
    String jsonpodatki2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_zacetna);
        tv = (TextView)findViewById(R.id.tvPrijavljenUporabnik);
        tv.setText("Prijavljeni ste kot: "+ trenutni.getUpIme() +" "+trenutni.getUpPriimek()+"\n" +trenutni.getUpEmail());
    }

    public void funkcijaOglasi(View view) {
        Intent i = new Intent(ZacetnaActivity.this, OglasiActivity.class);
        startActivity(i);
    }

    public void funkcijaSporočila(View view) {
        sporocila = new ArrayList<>();
        AsyncSporocilaPoslanaTask neki = new AsyncSporocilaPoslanaTask();
        neki.execute((Void) null);

    }



    public class AsyncSporocilaPoslanaTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                jsonpodatki=Connections.getConnection("http://10.0.2.2:8080/apligs-rest/v1/sporocila/poslano/"+Integer.toString(prijUporabnik.getIdUporabnika()));
                jsonpodatki="{ 'sporocila': " + jsonpodatki + "}";
                jsonpodatki2=Connections.getConnection("http://10.0.2.2:8080/apligs-rest/v1/sporocila/prejeto/"+Integer.toString(prijUporabnik.getIdUporabnika()));
                jsonpodatki2="{ 'sporocila': " + jsonpodatki2 + "}";
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            try {
                System.out.println(jsonpodatki);
                jsonObject = new JSONObject(jsonpodatki);
                JSONArray jsonArray = jsonObject.getJSONArray("sporocila");
                int count =0;
                int idSporocila;
                String spPoslano;
                String spVsebina;
                String spZadeva;
                String zaKoga;
                String odKoga;
                while(count<jsonArray.length()){
                    JSONObject JO = jsonArray.getJSONObject(count);
                    count++;
                    idSporocila= JO.getInt("idSporocila");
                    spPoslano= JO.getString("spPoslano");
                    spVsebina=JO.getString("spVsebina");
                    spZadeva=JO.getString("spZadeva");
                    zaKoga=JO.getString("uporabnik1");
                    odKoga=JO.getString("uporabnik2");
                    sporocila.add(new Sporocilo(idSporocila,spPoslano,spVsebina,spZadeva,zaKoga,odKoga));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(jsonpodatki2);
                jsonObject = new JSONObject(jsonpodatki2);
                JSONArray jsonArray = jsonObject.getJSONArray("sporocila");
                int count =0;
                int idSporocila;
                String spPoslano;
                String spVsebina;
                String spZadeva;
                String zaKoga;
                String odKoga;
                while(count<jsonArray.length()){
                    JSONObject JO = jsonArray.getJSONObject(count);
                    count++;
                    idSporocila= JO.getInt("idSporocila");
                    spPoslano= JO.getString("spPoslano");
                    spVsebina=JO.getString("spVsebina");
                    spZadeva=JO.getString("spZadeva");
                    zaKoga=JO.getString("uporabnik1");
                    odKoga=JO.getString("uporabnik2");
                    sporocila.add(new Sporocilo(idSporocila,spPoslano,spVsebina,spZadeva,zaKoga,odKoga));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Intent a = new Intent();
            a.setClass(getApplicationContext(),SporocilaActivity.class);
            startActivity(a);
        }
    }








}
