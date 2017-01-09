package si.fri.prpo.zrna.vmesniki;

import java.util.List;

import javax.ejb.Local;

import si.fri.tpo.model.Sporocilo;

@Local
public interface UpravljalecSporocilSBLocal {
	List<Sporocilo> vrniVsaSporocila();

	void shraniSporocilo(Sporocilo sporocilo);
	
	List<Sporocilo> vrniPrejeto(int id);
	
	List<Sporocilo> vrniPoslano(int id);

	Sporocilo vrniSporocilo(int id);

	void posodobiSporocilo(Sporocilo sporocilo);

	void zbrisiSporocilo(int id);

	List<Sporocilo> vrniVsaSporocila(int offset, int limit);
}
