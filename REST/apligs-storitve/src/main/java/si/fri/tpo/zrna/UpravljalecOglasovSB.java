package si.fri.tpo.zrna;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.fri.prpo.zrna.vmesniki.UpravljalecOglasovSBLocal;
import si.fri.prpo.zrna.vmesniki.UpravljalecOglasovSBRemote;
import si.fri.tpo.model.Ogla;
import si.fri.tpo.model.Uporabnik;

/**
 * Session Bean implementation class UpravljalecOglasovSB
 */
@Stateless
public class UpravljalecOglasovSB implements UpravljalecOglasovSBRemote, UpravljalecOglasovSBLocal {
	@PersistenceContext(unitName="apligs-jpa")
	private EntityManager em;
	
	@Override
	public List<Ogla> vrniVseOglase() {
		return em.createNamedQuery("Ogla.findAll").getResultList();
	}

	@Override
	public void shraniOglas(Ogla oglas) {
		em.persist(oglas);
	}

	@Override
	public Ogla vrniOglas(int id) {
		return (Ogla)em.createNamedQuery("Ogla.findId").setParameter("id", id).getSingleResult();
	}

	@Override
	public void posodobiOglas(Ogla oglas) {
		// TODO Posodobi uporabnik em.merge
		
	}

	@Override
	public void zbrisiOglas(int id) {
		em.createNamedQuery("Ogla.deleteId").setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Ogla> vrniVseOglase(int offset, int limit) {
		return em.createNamedQuery("Ogla.findAll").setFirstResult(offset).setMaxResults(limit).getResultList();
	}

}
