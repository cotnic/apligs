package si.fri.tpo.zrna;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.fri.prpo.zrna.vmesniki.UpravljalecInstrumentovSBLocal;
import si.fri.prpo.zrna.vmesniki.UpravljalecInstrumentovSBRemote;
import si.fri.tpo.model.Instrument;

/**
 * Session Bean implementation class UpravljalecInstrumentovSB
 */
@Stateless
public class UpravljalecInstrumentovSB implements UpravljalecInstrumentovSBRemote, UpravljalecInstrumentovSBLocal {
	@PersistenceContext(unitName="apligs-jpa")
	private EntityManager em;


	@Override
	public List<Instrument> vrniVseInstrumente() {
		return em.createNamedQuery("Instrument.findAll").getResultList();
	}

	@Override
	public void shraniInstrument(Instrument instrument) {
		em.persist(instrument);
		
	}

	@Override
	public Instrument vrniInstrument(int id) {
		return (Instrument)em.createNamedQuery("Instrument.findId").setParameter("id", id).getSingleResult();
	}

	@Override
	public void posodobiInstrument(Instrument instrument) {
		em.merge(instrument);		
	}

	@Override
	public void zbrisiInstrument(int id) {
		em.createNamedQuery("Instrument.deleteId").setParameter("id", id).executeUpdate();
	}

}
