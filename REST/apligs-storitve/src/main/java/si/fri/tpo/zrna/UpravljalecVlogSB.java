package si.fri.tpo.zrna;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.fri.prpo.zrna.vmesniki.UpravljalecVlogSBLocal;
import si.fri.prpo.zrna.vmesniki.UpravljalecVlogSBRemote;
import si.fri.tpo.model.Vloga;

/**
 * Session Bean implementation class UpravljalecVlogSB
 */
@Stateless
public class UpravljalecVlogSB implements UpravljalecVlogSBRemote, UpravljalecVlogSBLocal {
	@PersistenceContext(unitName="apligs-jpa")
	private EntityManager em;

	@Override
	public List<Vloga> vrniVseVloge() {
		return em.createNamedQuery("Vloga.findAll").getResultList();
	}

	@Override
	public Vloga vrniVlogo(int id) {
		return (Vloga)em.createNamedQuery("Vloga.findId").setParameter("id", id).getSingleResult();
	}

}
