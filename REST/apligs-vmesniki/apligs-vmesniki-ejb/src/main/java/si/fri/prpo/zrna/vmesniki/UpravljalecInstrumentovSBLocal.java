package si.fri.prpo.zrna.vmesniki;

import java.util.List;

import javax.ejb.Local;

import si.fri.tpo.model.Instrument;

@Local
public interface UpravljalecInstrumentovSBLocal {
	List<Instrument> vrniVseInstrumente();

	void shraniInstrument(Instrument instrument);

	Instrument vrniInstrument(int id);

	void posodobiInstrument(Instrument instrument);

	void zbrisiInstrument(int id);
}
