package co.edu.ufps.dao;

import javax.persistence.NoResultException;

import co.edu.ufps.entities.Votante;
import co.edu.ufps.util.Conexion;
import co.edu.ufps.util.GenericDAO;

public class VotanteDAO extends Conexion<Votante> implements GenericDAO<Votante> {
	public VotanteDAO () {
		super(Votante.class);
	}	
	
	public Votante buscarPorDocumento(String documento) {
		Votante v = null;
		try {
		v = super.getEm().createNamedQuery(Votante.class.getSimpleName()+".findCC", Votante.class).setParameter("documento",documento).getSingleResult();
		}catch(NoResultException e) {
		}
		return v;
	}
}