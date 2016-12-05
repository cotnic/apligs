package com.cotnic.apligs.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the instrument database table.
 * 
 */
@Entity
@NamedQuery(name="Instrument.findAll", query="SELECT i FROM Instrument i")
public class Instrument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_instrument")
	private int idInstrument;

	@Column(name="in_naziv")
	private String inNaziv;

	//bi-directional many-to-many association to Uporabnik
	@ManyToMany(mappedBy="instruments")
	private List<Uporabnik> uporabniks;

	public Instrument() {
	}

	public int getIdInstrument() {
		return this.idInstrument;
	}

	public void setIdInstrument(int idInstrument) {
		this.idInstrument = idInstrument;
	}

	public String getInNaziv() {
		return this.inNaziv;
	}

	public void setInNaziv(String inNaziv) {
		this.inNaziv = inNaziv;
	}

	public List<Uporabnik> getUporabniks() {
		return this.uporabniks;
	}

	public void setUporabniks(List<Uporabnik> uporabniks) {
		this.uporabniks = uporabniks;
	}

}