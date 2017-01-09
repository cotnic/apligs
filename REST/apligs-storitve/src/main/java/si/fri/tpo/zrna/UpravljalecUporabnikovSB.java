package si.fri.tpo.zrna;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.fri.prpo.zrna.vmesniki.UpravljalecUporabnikovSBLocal;
import si.fri.prpo.zrna.vmesniki.UpravljalecUporabnikovSBRemote;
import si.fri.tpo.model.Uporabnik;

/**
 * Session Bean implementation class UpravljalecUporabnikovSB
 */
@Stateless
public class UpravljalecUporabnikovSB implements UpravljalecUporabnikovSBRemote, UpravljalecUporabnikovSBLocal {
	@PersistenceContext(unitName="apligs-jpa")
	private EntityManager em;
	

	@Override
	public List<Uporabnik> vrniVseUporabnike() {
		return em.createNamedQuery("Uporabnik.findAll").getResultList();
	}

	@Override
	public List<Uporabnik> vrniVseUporabnike(int offset, int limit) {
		return em.createNamedQuery("Uporabnik.findAll").setFirstResult(offset).setMaxResults(limit).getResultList();
	}

	@Override
	public void shraniUporabnika(Uporabnik uporabnik) {
		em.persist(uporabnik);
	}

	@Override
	public Uporabnik vrniUporabnika(int id) {
		return (Uporabnik)em.createNamedQuery("Uporabnik.findId").setParameter("id", id).getSingleResult();
	}

	@Override
	public void posodobiUporabnika(Uporabnik uporabnik) {
		em.merge(uporabnik);
	}

	@Override
	public void zbrisiUporabnika(int id) {
		em.createNamedQuery("Uporabnik.deleteId").setParameter("id", id).executeUpdate();
	}

	@Override
	public Uporabnik prijaviUporabnika(String email, String password) {
		try {
			return (Uporabnik)em.createNamedQuery("Uporabnik.prijavi")
					.setParameter("email", email)
					.setParameter("geslo", password)
					.getSingleResult();
		}catch(Exception ex) {
			return null;
		}
		
	}

}
