package si.fri.tpo.zrna;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.fri.prpo.zrna.vmesniki.UpravljalecZvrstiSBLocal;
import si.fri.prpo.zrna.vmesniki.UpravljalecZvrstiSBRemote;
import si.fri.tpo.model.Zvrst;

/**
 * Session Bean implementation class UpravljalecZvrstiSB
 */
@Stateless
public class UpravljalecZvrstiSB implements UpravljalecZvrstiSBRemote, UpravljalecZvrstiSBLocal {
	@PersistenceContext(unitName="apligs-jpa")
	private EntityManager em;

	@Override
	public List<Zvrst> vrniVseZvrsti() {
		return em.createNamedQuery("Zvrst.findAll").getResultList();
	}

	@Override
	public Zvrst vrniZvrst(int id) {
		return (Zvrst)em.createNamedQuery("Zvrst.findId").setParameter("id", id).getSingleResult();
	}

}
