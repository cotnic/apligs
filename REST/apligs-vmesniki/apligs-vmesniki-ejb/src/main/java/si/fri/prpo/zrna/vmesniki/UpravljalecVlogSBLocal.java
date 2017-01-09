package si.fri.prpo.zrna.vmesniki;

import java.util.List;

import javax.ejb.Local;

import si.fri.tpo.model.Vloga;

@Local
public interface UpravljalecVlogSBLocal {
	List<Vloga> vrniVseVloge();


	Vloga vrniVlogo(int id);
}
