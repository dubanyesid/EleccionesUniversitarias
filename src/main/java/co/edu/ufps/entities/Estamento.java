package co.edu.ufps.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estamento database table.
 * 
 */
@Entity
@NamedQuery(name="Estamento.findAll", query="SELECT e FROM Estamento e")
public class Estamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional one-to-one association to Eleccion
	@OneToOne
	@JoinColumn(name="id")
	private Eleccion eleccion;

	//bi-directional one-to-one association to Voto
	@OneToOne(mappedBy="estamento")
	private Voto voto;

	public Estamento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Eleccion getEleccion() {
		return this.eleccion;
	}

	public void setEleccion(Eleccion eleccion) {
		this.eleccion = eleccion;
	}

	public Voto getVoto() {
		return this.voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

}