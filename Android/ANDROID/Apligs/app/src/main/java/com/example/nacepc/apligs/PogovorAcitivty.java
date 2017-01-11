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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PogovorAcitivty extends AppCompatActivity {
    Uporabnik trenutni= LogInActivity.trenutnoPrijavljeni;
    ArrayList<Sporocilo> sporocila = ZacetnaActivity.sporocila;
    String izbraniZaKlepet = SporocilaActivity.hurara.split("\n")[1];
    ListView lv;
    EditText et;
    JSONObject obj;

    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Sporocilo> samoZUporabnikoma= new ArrayList<Sporocilo>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pogovor_acitivty);
        for(Sporocilo s : sporocila){
            if(s.getZaKoga().getUpEmail().equals(izbraniZaKlepet) && s.getOdKoga().getUpEmail().equals(trenutni.getUpEmail())){
                samoZUporabnikoma.add(s);
            }
            if(s.getOdKoga().getUpEmail().equals(izbraniZaKlepet) && s.getZaKoga().getUpEmail().equals(trenutni.getUpEmail())){
                samoZUporabnikoma.add(s);
            }
        }

        Collections.sort(samoZUporabnikoma, new Comparator<Sporocilo>() {
            @Override
            public int compare(Sporocilo p1, Sporocilo p2) {
                return p1.getId() - p2.getId(); // Ascending
            }

        });

        ArrayList<String> maili = new ArrayList<>();
        for(Sporocilo s : samoZUporabnikoma){
            maili.add(s.getOdKoga().getUpIme()+" "+s.getOdKoga().getUpPriimek()+"["+s.getPoslano()+"]: "+s.getZadeva());
        }

        ListView lv = (ListView)findViewById(R.id.lvSporocilaUpo);
        String[] seznam = new String[samoZUporabnikoma.size()];
        int i=0;
        for(String s : maili){
            seznam[i++]=s;
        }

        adapter = new ArrayAdapter<String>(PogovorAcitivty.this, android.R.layout.simple_list_item_1, seznam);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void funkcijaPosljiSporociloDve(View view) {
        et = (EditText) findViewById(R.id.etposljiSporociloDva);
        String sporocilo1 = et.getText().toString();
        obj = new JSONObject();
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date = df.format(Calendar.getInstance().getTime());
            obj.put("spPoslano", date);
            obj.put("spVsebina", sporocilo1);
            obj.put("spZadeva", "Krneki");
            obj.put("uporabnik1", new JSONObject().put("idUporabnik",trenutni.getIdUporabnika()));
            obj.put("uporabnik2", new JSONObject().put("idUporabnik",SporocilaActivity.izbraniZaPogovor.getIdUporabnika()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("Tle ga sesuje");
        AsyncPosljiSporocilo2Task neki3 = new AsyncPosljiSporocilo2Task();
        neki3.execute((Void) null);
    }


    public class AsyncPosljiSporocilo2Task extends AsyncTask<Void, Void, Void> {

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
            Toast.makeText(PogovorAcitivty.this, "Sporočilo uspešno poslano", Toast.LENGTH_LONG).show();
            et = (EditText)findViewById(R.id.etposljiSporociloDva);
            et.setText("");
            Intent a = new Intent();
            a.setClass(getApplicationContext(),ZacetnaActivity.class);
            startActivity(a);

        }
    }
}
