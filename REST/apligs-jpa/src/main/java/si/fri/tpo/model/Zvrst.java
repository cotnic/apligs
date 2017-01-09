package si.fri.tpo.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the zvrst database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Zvrst.findAll", query="SELECT z FROM Zvrst z"),
	@NamedQuery(name="Zvrst.findId", query="SELECT z FROM Zvrst z WHERE z.idZvrst = :id"),
	@NamedQuery(name="Zvrst.deleteAll", query="DELETE FROM Zvrst"),
	@NamedQuery(name="Zvrst.deleteId", query="DELETE FROM Zvrst z WHERE z.idZvrst = :id")
})
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
	private List<Ogla> oglas;

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

	@XmlTransient
	public List<Uporabnik> getUporabniks() {
		return this.uporabniks;
	}

	public void setUporabniks(List<Uporabnik> uporabniks) {
		this.uporabniks = uporabniks;
	}

	@XmlTransient
	public List<Ogla> getOglas() {
		return this.oglas;
	}

	public void setOglas(List<Ogla> oglas) {
		this.oglas = oglas;
	}

	public Ogla addOgla(Ogla ogla) {
		getOglas().add(ogla);
		ogla.setZvrst(this);

		return ogla;
	}

	public Ogla removeOgla(Ogla ogla) {
		getOglas().remove(ogla);
		ogla.setZvrst(null);

		return ogla;
	}

}