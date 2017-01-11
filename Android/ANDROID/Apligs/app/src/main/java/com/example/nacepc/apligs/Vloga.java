package com.example.nacepc.apligs;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by NACEPC on 1/10/2017.
 */

public class Vloga {
    private int idVloga;
    private String vlNaziv;

    public Vloga(String neki){
        try {
            JSONObject jsonObject = new JSONObject(neki);
            this.idVloga = jsonObject.getInt("idVloga");
            this.vlNaziv=jsonObject.getString("vlNaziv");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public int getIdVloga() {
        return idVloga;
    }

    public void setIdVloga(int idVloga) {
        this.idVloga = idVloga;
    }

    public String getVlNaziv() {
        return vlNaziv;
    }

    public void setVlNaziv(String vlNaziv) {
        this.vlNaziv = vlNaziv;
    }
}
