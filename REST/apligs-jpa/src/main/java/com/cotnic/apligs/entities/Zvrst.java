package com.cotnic.apligs.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the zvrst database table.
 * 
 */
@Entity
@NamedQuery(name="Zvrst.findAll", query="SELECT z FROM Zvrst z")
public class Zvrst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_zvrst")
	private int idZvrst;

	@Column(name="zv_naziv")
	private String zvNaziv;

	//bi-directional many-to-many association to Uporabnik
	@ManyToMany(mappedBy="zvrsts")
	private List<Uporabnik> uporabniks;

	//bi-directional many-to-one association to Ogla
	@OneToMany(mappedBy="zvrst")
	private List<Oglas> oglas;

	public Zvrst() {
	}

	public int getIdZvrst() {
		return this.idZvrst;
	}

	public void setIdZvrst(int idZvrst) {
		this.idZvrst = idZvrst;
	}

	public String getZvNaziv() {
		return this.zvNaziv;
	}

	public void setZvNaziv(String zvNaziv) {
		this.zvNaziv = zvNaziv;
	}

	public List<Uporabnik> getUporabniks() {
		return this.uporabniks;
	}

	public void setUporabniks(List<Uporabnik> uporabniks) {
		this.uporabniks = uporabniks;
	}

	public List<Oglas> getOglas() {
		return this.oglas;
	}

	public void setOglas(List<Oglas> oglas) {
		this.oglas = oglas;
	}

	public Oglas addOgla(Oglas ogla) {
		getOglas().add(ogla);
		ogla.setZvrst(this);

		return ogla;
	}

	public Oglas removeOgla(Oglas ogla) {
		getOglas().remove(ogla);
		ogla.setZvrst(null);

		return ogla;
	}

}