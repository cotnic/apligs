package si.fri.tpo.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the lokacija database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Lokacija.findAll", query="SELECT l FROM Lokacija l"),
	@NamedQuery(name="Lokacija.findId", query="SELECT l FROM Lokacija l WHERE l.postnaStevilka = :id"),
	@NamedQuery(name="Lokacija.deleteAll", query="DELETE FROM Lokacija"),
	@NamedQuery(name="Lokacija.deleteId", query="DELETE FROM Lokacija l WHERE l.postnaStevilka = :id")
})
public class Lokacija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="postna_stevilka")
	private int postnaStevilka;

	@Column(name="lo_naziv")
	private String loNaziv;

	//bi-directional many-to-one association to Uporabnik
	@OneToMany(mappedBy="lokacija")
	private List<Uporabnik> uporabniks;

	public Lokacija() {
	}

	public int getPostnaStevilka() {
		return this.postnaStevilka;
	}

	public void setPostnaStevilka(int postnaStevilka) {
		this.postnaStevilka = postnaStevilka;
	}

	public String getLoNaziv() {
		return this.loNaziv;
	}

	public void setLoNaziv(String loNaziv) {
		this.loNaziv = loNaziv;
	}

	@XmlTransient
	public List<Uporabnik> getUporabniks() {
		return this.uporabniks;
	}

	public void setUporabniks(List<Uporabnik> uporabniks) {
		this.uporabniks = uporabniks;
	}

	public Uporabnik addUporabnik(Uporabnik uporabnik) {
		getUporabniks().add(uporabnik);
		uporabnik.setLokacija(this);

		return uporabnik;
	}

	public Uporabnik removeUporabnik(Uporabnik uporabnik) {
		getUporabniks().remove(uporabnik);
		uporabnik.setLokacija(null);

		return uporabnik;
	}

}