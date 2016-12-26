package si.fri.prpo.zrna.vmesniki;

import java.util.List;

import javax.ejb.Local;

import si.fri.tpo.model.Sporocilo;

@Local
public interface UpravljalecSporocilSBLocal {
	List<Sporocilo> vrniVseOglase();

	void shraniUporabnika(Sporocilo sporocilo);

	Sporocilo vrniUporabnika(int id);

	void posodobiUporabnika(Sporocilo sporocilo);

	void zbrisiUporabnika(int id);

	List<Sporocilo> vrniVseUporabnike(int offset, int limit);
}
