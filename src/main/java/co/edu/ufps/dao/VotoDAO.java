package co.edu.ufps.dao;

import javax.persistence.NoResultException;

import co.edu.ufps.entities.Voto;
import co.edu.ufps.util.Conexion;
import co.edu.ufps.util.GenericDAO;

public class VotoDAO extends Conexion<Voto> implements GenericDAO<Voto> {
	public VotoDAO () {
		super(Voto.class);
	}
	
	public Voto buscarPorUUID(String uuid) {
		Voto v = null;
		try {
		v = super.getEm().createNamedQuery(Voto.class.getSimpleName()+".findUUID", Voto.class).setParameter("uuid",uuid).getSingleResult();
		}catch(NoResultException e) {
		}
		return v;
	}
}