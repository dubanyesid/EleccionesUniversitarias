package co.edu.ufps.dao;

import co.edu.ufps.entities.Voto;
import co.edu.ufps.util.Conexion;
import co.edu.ufps.util.GenericDAO;

public class VotoDAO extends Conexion<Voto> implements GenericDAO<Voto> {
	public VotoDAO () {
		super(Voto.class);
	}
}