package co.edu.ufps.dao;

import co.edu.ufps.entities.Eleccion;
import co.edu.ufps.util.Conexion;
import co.edu.ufps.util.GenericDAO;

public class EleccionDAO extends Conexion<Eleccion> implements GenericDAO<Eleccion> {
	public EleccionDAO () {
		super(Eleccion.class);
	}
}