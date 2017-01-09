package si.fri.prpo.zrna.vmesniki;

import java.util.List;

import javax.ejb.Local;

import si.fri.tpo.model.Lokacija;

@Local
public interface UpravljalecLokacijSBLocal {
	List<Lokacija> vrniVseLokacije();


	Lokacija vrniLokacijo(int id);
}
