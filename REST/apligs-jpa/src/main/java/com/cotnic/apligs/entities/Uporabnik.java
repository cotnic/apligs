package com.cotnic.apligs.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the uporabnik database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Uporabnik.findAll", query="SELECT u FROM Uporabnik u"),
	@NamedQuery(name="Uporabnik.findId", query="SELECT u FROM Uporabnik u WHERE u.idUporabnik = :id")
	})
public class Uporabnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_uporabnik")
	private int idUporabnik;

	@Column(name="up_email")
	private String upEmail;

	@Column(name="up_geslo")
	private String upGeslo;

	@Column(name="up_ime")
	private String upIme;

	@Column(name="up_priimek")
	private String upPriimek;

	@Temporal(TemporalType.DATE)
	@Column(name="up_ustvarjen")
	private Date upUstvarjen;

	//bi-directional many-to-many association to Instrument
	@ManyToMany
	@JoinTable(
		name="igra"
		, joinColumns={
			@JoinColumn(name="id_uporabnik")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_instrument")
			}
		)
	private List<Instrument> instruments;

	//bi-directional many-to-many association to Zvrst
	@ManyToMany
	@JoinTable(
		name="izvaja"
		, joinColumns={
			@JoinColumn(name="id_uporabnik")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_zvrst")
			}
		)
	private List<Zvrst> zvrsts;

	//bi-directional many-to-one association to Ogla
	@OneToMany(mappedBy="uporabnik")
	private List<Oglas> oglas;

	//bi-directional many-to-one association to Sporocilo
	@OneToMany(mappedBy="uporabnik1")
	private List<Sporocilo> sporocilos1;

	//bi-directional many-to-one association to Sporocilo
	@OneToMany(mappedBy="uporabnik2")
	private List<Sporocilo> sporocilos2;

	//bi-directional many-to-one association to Lokacija
	@ManyToOne
	@JoinColumn(name="postna_stevilka")
	private Lokacija lokacija;

	//bi-directional many-to-one association to Vloga
	@ManyToOne
	@JoinColumn(name="id_vloga")
	private Vloga vloga;

	public Uporabnik() {
	}

	public int getIdUporabnik() {
		return this.idUporabnik;
	}

	public void setIdUporabnik(int idUporabnik) {
		this.idUporabnik = idUporabnik;
	}

	public String getUpEmail() {
		return this.upEmail;
	}

	public void setUpEmail(String upEmail) {
		this.upEmail = upEmail;
	}

	public String getUpGeslo() {
		return this.upGeslo;
	}

	public void setUpGeslo(String upGeslo) {
		this.upGeslo = upGeslo;
	}

	public String getUpIme() {
		return this.upIme;
	}

	public void setUpIme(String upIme) {
		this.upIme = upIme;
	}

	public String getUpPriimek() {
		return this.upPriimek;
	}

	public void setUpPriimek(String upPriimek) {
		this.upPriimek = upPriimek;
	}

	public Date getUpUstvarjen() {
		return this.upUstvarjen;
	}

	public void setUpUstvarjen(Date upUstvarjen) {
		this.upUstvarjen = upUstvarjen;
	}

	public List<Instrument> getInstruments() {
		return this.instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	public List<Zvrst> getZvrsts() {
		return this.zvrsts;
	}

	public void setZvrsts(List<Zvrst> zvrsts) {
		this.zvrsts = zvrsts;
	}

	public List<Oglas> getOglas() {
		return this.oglas;
	}

	public void setOglas(List<Oglas> oglas) {
		this.oglas = oglas;
	}

	public Oglas addOgla(Oglas ogla) {
		getOglas().add(ogla);
		ogla.setUporabnik(this);

		return ogla;
	}

	public Oglas removeOgla(Oglas ogla) {
		getOglas().remove(ogla);
		ogla.setUporabnik(null);

		return ogla;
	}

	public List<Sporocilo> getSporocilos1() {
		return this.sporocilos1;
	}

	public void setSporocilos1(List<Sporocilo> sporocilos1) {
		this.sporocilos1 = sporocilos1;
	}

	public Sporocilo addSporocilos1(Sporocilo sporocilos1) {
		getSporocilos1().add(sporocilos1);
		sporocilos1.setUporabnik1(this);

		return sporocilos1;
	}

	public Sporocilo removeSporocilos1(Sporocilo sporocilos1) {
		getSporocilos1().remove(sporocilos1);
		sporocilos1.setUporabnik1(null);

		return sporocilos1;
	}

	public List<Sporocilo> getSporocilos2() {
		return this.sporocilos2;
	}

	public void setSporocilos2(List<Sporocilo> sporocilos2) {
		this.sporocilos2 = sporocilos2;
	}

	public Sporocilo addSporocilos2(Sporocilo sporocilos2) {
		getSporocilos2().add(sporocilos2);
		sporocilos2.setUporabnik2(this);

		return sporocilos2;
	}

	public Sporocilo removeSporocilos2(Sporocilo sporocilos2) {
		getSporocilos2().remove(sporocilos2);
		sporocilos2.setUporabnik2(null);

		return sporocilos2;
	}

	public Lokacija getLokacija() {
		return this.lokacija;
	}

	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
	}

	public Vloga getVloga() {
		return this.vloga;
	}

	public void setVloga(Vloga vloga) {
		this.vloga = vloga;
	}

}