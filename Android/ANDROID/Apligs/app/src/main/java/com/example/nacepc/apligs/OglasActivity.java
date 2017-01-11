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
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class OglasActivity extends AppCompatActivity {
    TextView tv;
    EditText et;
    JSONObject obj;
    Oglas izbranOglas = OglasiActivity.izbraniOglasPravi; // podatki oglasa in njegovega uporabnika
    Uporabnik izbranUporabnik = LogInActivity.trenutnoPrijavljeni; // podatki prijavljenega uporabnika
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oglas);
        tv=(TextView)findViewById(R.id.tvNaslov);
        tv.setText(izbranOglas.getOgNaslov());
        tv=(TextView)findViewById(R.id.tvOpis);
        tv.setText("Opis: "+ izbranOglas.getOgOpis() +"\nZvrst: "+izbranOglas.getZvrst().getZvNaziv()+"\nDatum Objave: " + izbranOglas.getOgObjavljeno()+"\nObjavil: "+izbranOglas.getUporabnik().getUpIme() +" " +izbranOglas.getUporabnik().getUpPriimek() +
        "\nEmail: "+ izbranOglas.getUporabnik().getUpEmail() );
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void funkcijaPosljiSporociloEna(View view) {
        et = (EditText) findViewById(R.id.etPosljiSporocilo);
        String sporocilo1 = et.getText().toString();
        obj = new JSONObject();
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date = df.format(Calendar.getInstance().getTime());
            obj.put("spPoslano", date);
            obj.put("spVsebina", sporocilo1);
            obj.put("spZadeva", izbranOglas.getOgNaslov());
            obj.put("uporabnik1", new JSONObject().put("idUporabnik",izbranOglas.getUporabnik().getIdUporabnika()));
            obj.put("uporabnik2", new JSONObject().put("idUporabnik", izbranUporabnik.getIdUporabnika()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AsyncPosljiSporociloTask neki = new AsyncPosljiSporociloTask();
        neki.execute((Void) null);

    }




    public class AsyncPosljiSporociloTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                System.out.println(obj.toString());
                Connections.postConnection("http://10.0.2.2:8080/apligs-rest/v1/sporocila/", obj);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Toast.makeText(OglasActivity.this, "Sporočilo uspešno poslano", Toast.LENGTH_LONG).show();
            et = (EditText)findViewById(R.id.etPosljiSporocilo);
            et.setText("");


        }
    }


}
