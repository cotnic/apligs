package si.fri.tpo.zrna;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.fri.prpo.zrna.vmesniki.UpravljalecLokacijSBLocal;
import si.fri.prpo.zrna.vmesniki.UpravljalecLokacijSBRemote;
import si.fri.tpo.model.Lokacija;

/**
 * Session Bean implementation class UpravljalecLokacijSB
 */
@Stateless
public class UpravljalecLokacijSB implements UpravljalecLokacijSBRemote, UpravljalecLokacijSBLocal {
	@PersistenceContext(unitName="apligs-jpa")
	private EntityManager em;

	@Override
	public List<Lokacija> vrniVseLokacije() {
		return em.createNamedQuery("Lokacija.findAll").getResultList();
	}

	@Override
	public Lokacija vrniLokacijo(int id) {
		return (Lokacija)em.createNamedQuery("Lokacija.findId").setParameter("id", id).getSingleResult();
	}

}
