package co.edu.ufps.dao;

import co.edu.ufps.entities.Tipodocumento;
import co.edu.ufps.util.Conexion;
import co.edu.ufps.util.GenericDAO;

public class TipodocumentoDAO extends Conexion<Tipodocumento> implements GenericDAO<Tipodocumento> {
	public TipodocumentoDAO () {
		super(Tipodocumento.class);
	}
}