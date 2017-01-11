package com.example.nacepc.apligs;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by NACEPC on 1/10/2017.
 */

public class Zvrst {
    private int idZvrst;
    private String zvNaziv;

    public Zvrst(String neki){
        try {
            JSONObject jsonObject = new JSONObject(neki);
            idZvrst = jsonObject.getInt("idZvrst");
            zvNaziv=jsonObject.getString("zvNaziv");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public int getIdZvrst() {
        return idZvrst;
    }

    public void setIdZvrst(int idZvrst) {
        this.idZvrst = idZvrst;
    }

    public String getZvNaziv() {
        return zvNaziv;
    }

    public void setZvNaziv(String zvNaziv) {
        this.zvNaziv = zvNaziv;
    }
}
