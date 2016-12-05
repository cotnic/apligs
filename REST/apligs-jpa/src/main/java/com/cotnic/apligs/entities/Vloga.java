package com.cotnic.apligs.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vloga database table.
 * 
 */
@Entity
@NamedQuery(name="Vloga.findAll", query="SELECT v FROM Vloga v")
public class Vloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vloga")
	private int idVloga;

	@Column(name="vl_naziv")
	private String vlNaziv;

	//bi-directional many-to-one association to Ogla
	@OneToMany(mappedBy="vloga")
	private List<Oglas> oglas;

	//bi-directional many-to-one association to Uporabnik
	@OneToMany(mappedBy="vloga")
	private List<Uporabnik> uporabniks;

	public Vloga() {
	}

	public int getIdVloga() {
		return this.idVloga;
	}

	public void setIdVloga(int idVloga) {
		this.idVloga = idVloga;
	}

	public String getVlNaziv() {
		return this.vlNaziv;
	}

	public void setVlNaziv(String vlNaziv) {
		this.vlNaziv = vlNaziv;
	}

	public List<Oglas> getOglas() {
		return this.oglas;
	}

	public void setOglas(List<Oglas> oglas) {
		this.oglas = oglas;
	}

	public Oglas addOgla(Oglas ogla) {
		getOglas().add(ogla);
		ogla.setVloga(this);

		return ogla;
	}

	public Oglas removeOgla(Oglas ogla) {
		getOglas().remove(ogla);
		ogla.setVloga(null);

		return ogla;
	}

	public List<Uporabnik> getUporabniks() {
		return this.uporabniks;
	}

	public void setUporabniks(List<Uporabnik> uporabniks) {
		this.uporabniks = uporabniks;
	}

	public Uporabnik addUporabnik(Uporabnik uporabnik) {
		getUporabniks().add(uporabnik);
		uporabnik.setVloga(this);

		return uporabnik;
	}

	public Uporabnik removeUporabnik(Uporabnik uporabnik) {
		getUporabniks().remove(uporabnik);
		uporabnik.setVloga(null);

		return uporabnik;
	}

}