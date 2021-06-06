package co.edu.ufps.dao;

import co.edu.ufps.entities.Candidato;
import co.edu.ufps.util.Conexion;
import co.edu.ufps.util.GenericDAO;

public class CandidatoDAO extends Conexion<Candidato> implements GenericDAO<Candidato> {
	public CandidatoDAO() {
		super(Candidato.class);
	}
}
