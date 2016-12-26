package si.fri.prpo.zrna.vmesniki;

import java.util.List;

import javax.ejb.Local;

import si.fri.tpo.model.Uporabnik;

@Local
public interface UpravljalecUporabnikovSBLocal {

	List<Uporabnik> vrniVseUporabnike();

	void shraniUporabnika(Uporabnik uporabnik);

	Uporabnik vrniUporabnika(int id);
	
	Uporabnik prijaviUporabnika(String email, String password);

	void posodobiUporabnika(Uporabnik uporabnik);

	void zbrisiUporabnika(int id);

	List<Uporabnik> vrniVseUporabnike(int offset, int limit);
}
