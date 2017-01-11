package com.example.nacepc.apligs;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class SporocilaActivity extends AppCompatActivity {
    ArrayList<Sporocilo> sporocila = ZacetnaActivity.sporocila;
    Uporabnik prijUporabnik = LogInActivity.trenutnoPrijavljeni;
    public static String hurara;
    private ArrayAdapter<String> adapter;
    public static Uporabnik izbraniZaPogovor;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HashSet<String> maili = new HashSet<String>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sporocila);
        String trenutniMail=prijUporabnik.getUpEmail();
        for(int i=0; i<sporocila.size();i++){
            maili.add(sporocila.get(i).getOdKoga().getUpIme()+" " +sporocila.get(i).getOdKoga().getUpPriimek()+"\n" +sporocila.get(i).getOdKoga().getUpEmail());
            maili.add(sporocila.get(i).getZaKoga().getUpIme()+" " +sporocila.get(i).getZaKoga().getUpPriimek()+"\n" +sporocila.get(i).getZaKoga().getUpEmail());
        }
        maili.remove(prijUporabnik.getUpIme()+" " +prijUporabnik.getUpPriimek()+"\n"+prijUporabnik.getUpEmail());
        String krneki="";
        for(String s : maili){
            krneki+=s+"\n";
        }


        ListView lv = (ListView)findViewById(R.id.lvSeznamUporabnikov);
        String[] seznam = new String[maili.size()];
        int i=0;
        for(String s : maili){
            seznam[i++]=s;
        }

        adapter = new ArrayAdapter<String>(SporocilaActivity.this, android.R.layout.simple_list_item_1, seznam);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                hurara =parent.getItemAtPosition(position).toString();
                for (Sporocilo s :sporocila){
                    if(s.getOdKoga().getUpEmail().equals(hurara.split("\n")[1])){
                        izbraniZaPogovor=s.getOdKoga();
                        break;
                    }
                    if(s.getZaKoga().getUpEmail().equals(hurara.split("\n")[1])){
                        izbraniZaPogovor=s.getZaKoga();
                        break;
                    }
                }
                Intent i = new Intent(SporocilaActivity.this, PogovorAcitivty.class);
                startActivity(i);
            }
        });

    }




}
