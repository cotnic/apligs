package si.fri.tpo.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;


/**
 * The persistent class for the oglas database table.
 * 
 */
@Entity
@XmlRootElement
@Table(name="oglas")
@NamedQueries({
	@NamedQuery(name="Ogla.findAll", query="SELECT o FROM Ogla o"),
	@NamedQuery(name="Ogla.findId", query="SELECT o FROM Ogla o WHERE o.idOglas = :id"),
	@NamedQuery(name="Ogla.deleteAll", query="DELETE FROM Ogla"),
	@NamedQuery(name="Ogla.deleteId", query="DELETE FROM Ogla o WHERE o.idOglas = :id")
})
public class Ogla implements Serializable {
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
	
	@Column(name="og_band")
	private byte ogBand;

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

	public Ogla() {
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
	
	public byte getOgBand() {
		return this.ogBand;
	}

	public void setOgBand(byte ogBand) {
		this.ogBand = ogBand;
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