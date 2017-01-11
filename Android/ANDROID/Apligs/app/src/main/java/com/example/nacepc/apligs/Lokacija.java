package com.example.nacepc.apligs;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by NACEPC on 1/10/2017.
 */

public class Lokacija {
    private int postnaStevilka;
    private String loNaziv;

    public Lokacija(String neki){
        try {
            JSONObject jsonObject = new JSONObject(neki);
            this.postnaStevilka=jsonObject.getInt("postnaStevilka");
            this.loNaziv=jsonObject.getString("loNaziv");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getPostnaStevilka() {
        return postnaStevilka;
    }

    public void setPostnaStevilka(int postnaStevilka) {
        this.postnaStevilka = postnaStevilka;
    }

    public String getLoNaziv() {
        return loNaziv;
    }

    public void setLoNaziv(String loNaziv) {
        this.loNaziv = loNaziv;
    }
}
