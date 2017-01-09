package si.fri.prpo.zrna.vmesniki;

import java.util.List;

import javax.ejb.Local;

import si.fri.tpo.model.Zvrst;

@Local
public interface UpravljalecZvrstiSBLocal {
	List<Zvrst> vrniVseZvrsti();


	Zvrst vrniZvrst(int id);
}
