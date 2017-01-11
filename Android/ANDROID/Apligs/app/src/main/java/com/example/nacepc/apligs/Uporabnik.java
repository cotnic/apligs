package com.example.nacepc.apligs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by NACEPC on 1/10/2017.
 */

public class Uporabnik {
    private int idUporabnika;
    private String upEmail;
    private String upGeslo;
    private String upIme;
    private String upPriimek;
    private String upUstvarjen;
    private String upPicture;
    private Lokacija lokacija;
    private Vloga vloga;

    public Vloga getVloga() {
        return vloga;
    }

    public void setVloga(Vloga vloga) {
        this.vloga = vloga;
    }

    public Uporabnik(String neki){
        try {
            JSONObject jsonObject = new JSONObject(neki);
            this.idUporabnika=jsonObject.getInt("idUporabnik");
            this.upEmail=jsonObject.getString("upEmail");
            this.upGeslo=jsonObject.getString("upGeslo");
            this.upIme=jsonObject.getString("upIme");
            this.upPriimek=jsonObject.getString("upPriimek");
            this.upUstvarjen=jsonObject.getString("upUstvarjen");
            this.upPicture=jsonObject.getString("upPicture");
            this.lokacija = new Lokacija(jsonObject.getString("lokacija"));
            this.vloga = new Vloga(jsonObject.getString("vloga"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getIdUporabnika() {
        return idUporabnika;
    }

    public void setIdUporabnika(int idUporabnika) {
        this.idUporabnika = idUporabnika;
    }

    public String getUpEmail() {
        return upEmail;
    }

    public void setUpEmail(String upEmail) {
        this.upEmail = upEmail;
    }

    public String getUpGeslo() {
        return upGeslo;
    }

    public void setUpGeslo(String upGeslo) {
        this.upGeslo = upGeslo;
    }

    public String getUpIme() {
        return upIme;
    }

    public void setUpIme(String upIme) {
        this.upIme = upIme;
    }

    public String getUpUstvarjen() {
        return upUstvarjen;
    }

    public void setUpUstvarjen(String upUstvarjen) {
        this.upUstvarjen = upUstvarjen;
    }

    public String getUpPicture() {
        return upPicture;
    }

    public void setUpPicture(String upPicture) {
        this.upPicture = upPicture;
    }

    public String getUpPriimek() {
        return upPriimek;
    }

    public void setUpPriimek(String upPriimek) {
        this.upPriimek = upPriimek;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }
}
