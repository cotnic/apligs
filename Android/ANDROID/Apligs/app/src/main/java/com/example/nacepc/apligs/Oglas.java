package com.example.nacepc.apligs;

import java.util.Date;

/**
 * Created by NACEPC on 1/10/2017.
 */

public class Oglas {
    private int idOglasa;
    private String ogNaslov;
    private String ogObjavljeno;
    private String ogOpis;
    private int ogPremium;
    private int ogBand;
    private Zvrst zvrst;
    private Uporabnik uporabnik;


    public Oglas(int idOglasa, String ogNaslov, String ogObjavljeno, String ogOpis, int ogPremium, int ogBand, String zvrst, String uporabnik) {
        this.idOglasa = idOglasa;
        this.ogNaslov = ogNaslov;
        this.ogObjavljeno = ogObjavljeno;
        this.ogOpis = ogOpis;
        this.ogPremium = ogPremium;
        this.ogBand = ogBand;
        this.zvrst = new Zvrst(zvrst);
        this.uporabnik = new Uporabnik(uporabnik);

    }

    public int getIdOglasa() {
        return idOglasa;
    }

    public void setIdOglasa(int idOglasa) {
        this.idOglasa = idOglasa;
    }

    public String getOgNaslov() {
        return ogNaslov;
    }

    public void setOgNaslov(String ogNaslov) {
        this.ogNaslov = ogNaslov;
    }

    public String getOgObjavljeno() {
        return ogObjavljeno;
    }

    public void setOgObjavljeno(String ogObjavljeno) {
        this.ogObjavljeno = ogObjavljeno;
    }

    public String getOgOpis() {
        return ogOpis;
    }

    public void setOgOpis(String ogOpis) {
        this.ogOpis = ogOpis;
    }

    public int getOgPremium() {
        return ogPremium;
    }

    public void setOgPremium(int ogPremium) {
        this.ogPremium = ogPremium;
    }

    public int getOgBand() {
        return ogBand;
    }

    public void setOgBand(int ogBand) {
        this.ogBand = ogBand;
    }

    public Zvrst getZvrst() {
        return zvrst;
    }

    public void setZvrst(Zvrst zvrst) {
        this.zvrst = zvrst;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }



}
