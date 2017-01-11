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
 * @author mkotnik
 * @version 1.0
 */
@Stateless
public class UpravljalecUporabnikovSB implements UpravljalecUporabnikovSBRemote, UpravljalecUporabnikovSBLocal {
	@PersistenceContext(unitName="apligs-jpa")
	private EntityManager em;
	

	/**
	 * @return list of all users saved in database
	 */
	@Override
	public List<Uporabnik> vrniVseUporabnike() {
		return em.createNamedQuery("Uporabnik.findAll").getResultList();
	}

	/**
	 * Method used for paging
	 * @param offset where the results start
	 * @param number of how many results are shown from offset
	 */
	@Override
	public List<Uporabnik> vrniVseUporabnike(int offset, int limit) {
		return em.createNamedQuery("Uporabnik.findAll").setFirstResult(offset).setMaxResults(limit).getResultList();
	}

	/**
	 * Method for saving user into database
	 * @param input Uporabnik entity for saving
	 */
	@Override
	public void shraniUporabnika(Uporabnik uporabnik) {
		em.persist(uporabnik);
	}

	/**
	 * Method for searching a user which is specified based on ID
	 * @param id which identifies user
	 * @return entity Uporabnik based on ID that was specified
	 */
	@Override
	public Uporabnik vrniUporabnika(int id) {
		return (Uporabnik)em.createNamedQuery("Uporabnik.findId").setParameter("id", id).getSingleResult();
	}

	/**
	 * Method edits Uporabnik entity based on data we input
	 * @param input Uporabnik entity for update
	 */
	@Override
	public void posodobiUporabnika(Uporabnik uporabnik) {
		em.merge(uporabnik);
	}

	/**
	 * Method deletes user from database
	 * @param id which identifies which user to delete
	 */
	@Override
	public void zbrisiUporabnika(int id) {
		em.createNamedQuery("Uporabnik.deleteId").setParameter("id", id).executeUpdate();
	}

	/**
	 * Method which is used for login
	 * @param email identifies user (username)
	 * @param password for identification
	 */
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
