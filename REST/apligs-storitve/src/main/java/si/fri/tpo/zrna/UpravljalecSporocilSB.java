package si.fri.tpo.zrna;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.fri.prpo.zrna.vmesniki.UpravljalecSporocilSBLocal;
import si.fri.prpo.zrna.vmesniki.UpravljalecSporocilSBRemote;
import si.fri.prpo.zrna.vmesniki.UpravljalecUporabnikovSBLocal;
import si.fri.tpo.model.Sporocilo;
import si.fri.tpo.model.Uporabnik;

/**
 * Session Bean implementation class UpravljalecSporocilSB
 */
@Stateless
public class UpravljalecSporocilSB implements UpravljalecSporocilSBRemote, UpravljalecSporocilSBLocal {
	@PersistenceContext(unitName="apligs-jpa")
	private EntityManager em;

	@EJB
	UpravljalecUporabnikovSBLocal upravljalecUporabnikov;
	
	@Override
	public List<Sporocilo> vrniVsaSporocila() {
		return em.createNamedQuery("Sporocilo.findAll").getResultList();
	}
	
	@Override
	public List<Sporocilo> vrniPrejeto(int id) {
		Uporabnik uporabnik = upravljalecUporabnikov.vrniUporabnika(id);
		return em.createNamedQuery("Sporocilo.findPrejeto").setParameter("uporabnik", uporabnik).getResultList();
	}
	
	@Override
	public List<Sporocilo> vrniPoslano(int id) {
		Uporabnik uporabnik = upravljalecUporabnikov.vrniUporabnika(id);
		return em.createNamedQuery("Sporocilo.findPoslano").setParameter("uporabnik", uporabnik).getResultList();
	}

	@Override
	public void shraniSporocilo(Sporocilo sporocilo) {
		em.persist(sporocilo);
	}

	@Override
	public Sporocilo vrniSporocilo(int id) {
		return (Sporocilo)em.createNamedQuery("Sporocilo.findId").setParameter("id", id).getSingleResult();
	}

	@Override
	public void posodobiSporocilo(Sporocilo sporocilo) {
		em.merge(sporocilo);
	}

	@Override
	public void zbrisiSporocilo(int id) {
		em.createNamedQuery("Sporocilo.deleteId").setParameter("id", id).executeUpdate();
	}

	@Override
	public List<Sporocilo> vrniVsaSporocila(int offset, int limit) {
		return em.createNamedQuery("Sporocilo.findAll").setFirstResult(offset).setMaxResults(limit).getResultList();
	}

}
