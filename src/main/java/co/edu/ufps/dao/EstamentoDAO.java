package co.edu.ufps.dao;

import co.edu.ufps.entities.Estamento;
import co.edu.ufps.util.Conexion;
import co.edu.ufps.util.GenericDAO;

public class EstamentoDAO extends Conexion<Estamento> implements GenericDAO<Estamento> {
	public EstamentoDAO () {
		super(Estamento.class);
	}
}