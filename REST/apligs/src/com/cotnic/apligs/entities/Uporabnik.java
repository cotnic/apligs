package com.cotnic.apligs.entities;

import java.sql.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "uporabnik")
public class Uporabnik {

	private int idUporabnik;
	private int postna_stevilka;
	private int idVloga;
	private String upIme;
	private String upPriimek;
	private String upEmail;
	private Date upUstvarjen;
	
	public Uporabnik() { }
	
	public Uporabnik(int idUporabnik, int postna_stevilka, int idVloga, String upIme, String upPriimek, String upEmail,
			Date upUstvarjen) {
		super();
		this.idUporabnik = idUporabnik;
		this.postna_stevilka = postna_stevilka;
		this.idVloga = idVloga;
		this.upIme = upIme;
		this.upPriimek = upPriimek;
		this.upEmail = upEmail;
		this.upUstvarjen = upUstvarjen;
	}
	
	@XmlElement
	public int getIdUporabnik() {
		return idUporabnik;
	}
	public void setIdUporabnik(int idUporabnik) {
		this.idUporabnik = idUporabnik;
	}
	
	@XmlElement
	public int getPostna_stevilka() {
		return postna_stevilka;
	}
	public void setPostna_stevilka(int postna_stevilka) {
		this.postna_stevilka = postna_stevilka;
	}
	
	@XmlElement
	public int getIdVloga() {
		return idVloga;
	}
	public void setIdVloga(int idVloga) {
		this.idVloga = idVloga;
	}
	
	@XmlElement
	public String getUpIme() {
		return upIme;
	}
	public void setUpIme(String upIme) {
		this.upIme = upIme;
	}
	
	@XmlElement
	public String getUpPriimek() {
		return upPriimek;
	}
	public void setUpPriimek(String upPriimek) {
		this.upPriimek = upPriimek;
	}
	
	@XmlElement
	public String getUpEmail() {
		return upEmail;
	}
	public void setUpEmail(String upEmail) {
		this.upEmail = upEmail;
	}
	
	@XmlElement
	public Date getUpUstvarjen() {
		return upUstvarjen;
	}
	public void setUpUstvarjen(Date upUstvarjen) {
		this.upUstvarjen = upUstvarjen;
	}
	
	
}
