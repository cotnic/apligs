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
import java.util.List;

public class OglasiActivity extends AppCompatActivity {
    ArrayList<Oglas> seznamOglasov = new ArrayList<Oglas>();
    public static Oglas izbraniOglasPravi;
    public String izbranOglas;
    private ArrayAdapter<String> adapter;
    JSONObject jsonObject;
    String jsonpodatki;
    String proba1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oglasi);

        AsyncOglasiTask neki = new AsyncOglasiTask();
        neki.execute((Void) null);






    }

    public class AsyncOglasiTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                jsonpodatki=Connections.getConnection("http://10.0.2.2:8080/apligs-rest/v1/oglasi");
                jsonpodatki="{ 'oglasi': " + jsonpodatki + "}";
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
                JSONArray jsonArray = jsonObject.getJSONArray("oglasi");
                int count =0;
                int idOglasa;
                String ogNaslov;
                String ogObjavljeno;
                String ogOpis;
                int ogPremium;
                int ogBand;
                String zvrst;
                String uporabnik;
                int idVloge;
                while(count<jsonArray.length()){
                    JSONObject JO = jsonArray.getJSONObject(count);
                    count++;
                    idOglasa= JO.getInt("idOglas");
                    ogNaslov=JO.getString("ogNaslov");
                    ogObjavljeno=JO.getString("ogObjavljen");
                    ogOpis=JO.getString("ogOpis");
                    ogPremium=JO.getInt("ogPremium");
                    ogBand=JO.getInt("ogBand");
                    zvrst=JO.getString("zvrst");
                    uporabnik=JO.getString("uporabnik");
                    seznamOglasov.add(new Oglas(idOglasa,ogNaslov,ogObjavljeno,ogOpis,ogPremium,ogBand,zvrst,uporabnik));

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            ListView lv = (ListView)findViewById(R.id.lvOglasi);
            String[] seznam = new String[5];
            for(int i=0; i< seznamOglasov.size();i++){
                seznam[i] = seznamOglasov.get(i).getOgOpis()+"\nZvrst: "+seznamOglasov.get(i).getZvrst().getZvNaziv()+"\nDatum objave: " + seznamOglasov.get(i).getOgObjavljeno();
            }
            adapter = new ArrayAdapter<String>(OglasiActivity.this, android.R.layout.simple_list_item_1, seznam);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    izbranOglas =parent.getItemAtPosition(position).toString();
                    for(int i=0; i< seznamOglasov.size();i++){
                        if(izbranOglas.split("\n")[0].equals(seznamOglasov.get(i).getOgOpis())){
                            izbraniOglasPravi=seznamOglasov.get(i);
                            Intent b = new Intent(OglasiActivity.this, OglasActivity.class);
                            startActivity(b);
                        }
                    }

                }
            });

        }
    }
}
