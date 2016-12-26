package si.fri.prpo.zrna.vmesniki;

import java.util.List;

import javax.ejb.Local;

import si.fri.tpo.model.Ogla;

@Local
public interface UpravljalecOglasovSBLocal {
	List<Ogla> vrniVseOglase();

	void shraniOglas(Ogla oglas);

	Ogla vrniOglas(int id);

	void posodobiOglas(Ogla oglas);

	void zbrisiOglas(int id);

	List<Ogla> vrniVseOglase(int offset, int limit);
}
