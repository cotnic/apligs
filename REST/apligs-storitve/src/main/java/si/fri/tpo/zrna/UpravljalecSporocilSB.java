package si.fri.tpo.zrna;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.fri.prpo.zrna.vmesniki.UpravljalecSporocilSBLocal;
import si.fri.prpo.zrna.vmesniki.UpravljalecSporocilSBRemote;
import si.fri.tpo.model.Ogla;
import si.fri.tpo.model.Sporocilo;

/**
 * Session Bean implementation class UpravljalecSporocilSB
 */
@Stateless
public class UpravljalecSporocilSB implements UpravljalecSporocilSBRemote, UpravljalecSporocilSBLocal {
	@PersistenceContext(unitName="apligs-jpa")
	private EntityManager em;

	@Override
	public List<Sporocilo> vrniVseOglase() {
		return em.createNamedQuery("Sporocilo.findAll").getResultList();
	}

	@Override
	public void shraniUporabnika(Sporocilo sporocilo) {
		em.persist(sporocilo);
	}

	@Override
	public Sporocilo vrniUporabnika(int id) {
		return (Sporocilo)em.createNamedQuery("Sporocilo.findId").setParameter("id", id).getSingleResult();
	}

	@Override
	public void posodobiUporabnika(Sporocilo sporocilo) {
		// TODO Implement em.merge
		
	}

	@Override
	public void zbrisiUporabnika(int id) {
		em.createNamedQuery("Sporocilo.deleteId").setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Sporocilo> vrniVseUporabnike(int offset, int limit) {
		return em.createNamedQuery("Sporocilo.findAll").setFirstResult(offset).setMaxResults(limit).getResultList();
	}

}
