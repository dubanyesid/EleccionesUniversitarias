package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipodocumento database table.
 * 
 */
@Entity
@NamedQuery(name="Tipodocumento.findAll", query="SELECT t FROM Tipodocumento t")
public class Tipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	//bi-directional one-to-one association to Votante
	@OneToOne(mappedBy="tipodocumento")
	private Votante votante;

	public Tipodocumento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Votante getVotante() {
		return this.votante;
	}

	public void setVotante(Votante votante) {
		this.votante = votante;
	}

}