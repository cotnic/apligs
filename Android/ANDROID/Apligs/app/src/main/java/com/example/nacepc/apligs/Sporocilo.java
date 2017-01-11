package com.example.nacepc.apligs;

/**
 * Created by NACEPC on 1/11/2017.
 */

public class Sporocilo {
    private int id;
    private String poslano;
    private String vsebina;
    private String zadeva;
    private Uporabnik zaKoga;
    private Uporabnik odKoga;

    public Sporocilo(int id, String poslano, String zadeva, String vsebina, String zaKoga, String odKoga) {
        this.id = id;
        this.poslano = poslano;
        this.zadeva = zadeva;
        this.vsebina = vsebina;
        this.zaKoga = new Uporabnik(zaKoga);
        this.odKoga = new Uporabnik(odKoga);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoslano() {
        return poslano;
    }

    public void setPoslano(String poslano) {
        this.poslano = poslano;
    }

    public String getVsebina() {
        return vsebina;
    }

    public void setVsebina(String vsebina) {
        this.vsebina = vsebina;
    }

    public String getZadeva() {
        return zadeva;
    }

    public void setZadeva(String zadeva) {
        this.zadeva = zadeva;
    }

    public Uporabnik getOdKoga() {
        return odKoga;
    }

    public void setOdKoga(Uporabnik odKoga) {
        this.odKoga = odKoga;
    }

    public Uporabnik getZaKoga() {
        return zaKoga;
    }

    public void setZaKoga(Uporabnik zaKoga) {
        this.zaKoga = zaKoga;
    }
}
