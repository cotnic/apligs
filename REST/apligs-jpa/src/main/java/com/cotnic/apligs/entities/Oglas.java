package com.cotnic.apligs.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oglas database table.
 * 
 */
@Entity
@Table(name="oglas")
@NamedQuery(name="Oglas.findAll", query="SELECT o FROM Oglas o")
public class Oglas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oglas")
	private int idOglas;

	@Column(name="og_naslov")
	private String ogNaslov;

	@Temporal(TemporalType.DATE)
	@Column(name="og_objavljen")
	private Date ogObjavljen;

	@Column(name="og_opis")
	private String ogOpis;

	@Column(name="og_premium")
	private byte ogPremium;

	//bi-directional many-to-one association to Zvrst
	@ManyToOne
	@JoinColumn(name="id_zvrst")
	private Zvrst zvrst;

	//bi-directional many-to-one association to Uporabnik
	@ManyToOne
	@JoinColumn(name="id_uporabnik")
	private Uporabnik uporabnik;

	//bi-directional many-to-one association to Vloga
	@ManyToOne
	@JoinColumn(name="id_vloga")
	private Vloga vloga;

	public Oglas() {
	}

	public int getIdOglas() {
		return this.idOglas;
	}

	public void setIdOglas(int idOglas) {
		this.idOglas = idOglas;
	}

	public String getOgNaslov() {
		return this.ogNaslov;
	}

	public void setOgNaslov(String ogNaslov) {
		this.ogNaslov = ogNaslov;
	}

	public Date getOgObjavljen() {
		return this.ogObjavljen;
	}

	public void setOgObjavljen(Date ogObjavljen) {
		this.ogObjavljen = ogObjavljen;
	}

	public String getOgOpis() {
		return this.ogOpis;
	}

	public void setOgOpis(String ogOpis) {
		this.ogOpis = ogOpis;
	}

	public byte getOgPremium() {
		return this.ogPremium;
	}

	public void setOgPremium(byte ogPremium) {
		this.ogPremium = ogPremium;
	}

	public Zvrst getZvrst() {
		return this.zvrst;
	}

	public void setZvrst(Zvrst zvrst) {
		this.zvrst = zvrst;
	}

	public Uporabnik getUporabnik() {
		return this.uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	public Vloga getVloga() {
		return this.vloga;
	}

	public void setVloga(Vloga vloga) {
		this.vloga = vloga;
	}

}