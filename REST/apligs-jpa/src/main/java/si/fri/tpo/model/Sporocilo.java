package si.fri.tpo.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;


/**
 * The persistent class for the sporocilo database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Sporocilo.findAll", query="SELECT s FROM Sporocilo s"),
	@NamedQuery(name="Sporocilo.findId", query="SELECT s FROM Sporocilo s WHERE s.idSporocila = :id"),
	@NamedQuery(name="Sporocilo.deleteAll", query="DELETE FROM Sporocilo"),
	@NamedQuery(name="Sporocilo.deleteId", query="DELETE FROM Sporocilo s WHERE s.idSporocila = :id")
})
public class Sporocilo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sporocila")
	private int idSporocila;

	@Temporal(TemporalType.DATE)
	@Column(name="sp_poslano")
	private Date spPoslano;

	@Column(name="sp_vsebina")
	private String spVsebina;

	@Column(name="sp_zadeva")
	private String spZadeva;

	//bi-directional many-to-one association to Uporabnik
	@ManyToOne
	@JoinColumn(name="id_prejme")
	private Uporabnik uporabnik1;

	//bi-directional many-to-one association to Uporabnik
	@ManyToOne
	@JoinColumn(name="id_poslje")
	private Uporabnik uporabnik2;

	public Sporocilo() {
	}

	public int getIdSporocila() {
		return this.idSporocila;
	}

	public void setIdSporocila(int idSporocila) {
		this.idSporocila = idSporocila;
	}

	public Date getSpPoslano() {
		return this.spPoslano;
	}

	public void setSpPoslano(Date spPoslano) {
		this.spPoslano = spPoslano;
	}

	public String getSpVsebina() {
		return this.spVsebina;
	}

	public void setSpVsebina(String spVsebina) {
		this.spVsebina = spVsebina;
	}

	public String getSpZadeva() {
		return this.spZadeva;
	}

	public void setSpZadeva(String spZadeva) {
		this.spZadeva = spZadeva;
	}

	public Uporabnik getUporabnik1() {
		return this.uporabnik1;
	}

	public void setUporabnik1(Uporabnik uporabnik1) {
		this.uporabnik1 = uporabnik1;
	}

	public Uporabnik getUporabnik2() {
		return this.uporabnik2;
	}

	public void setUporabnik2(Uporabnik uporabnik2) {
		this.uporabnik2 = uporabnik2;
	}

}