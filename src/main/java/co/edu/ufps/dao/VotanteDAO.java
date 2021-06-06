package co.edu.ufps.dao;

import co.edu.ufps.entities.Votante;
import co.edu.ufps.util.Conexion;
import co.edu.ufps.util.GenericDAO;

public class VotanteDAO extends Conexion<Votante> implements GenericDAO<Votante> {
	public VotanteDAO () {
		super(Votante.class);
	}
}