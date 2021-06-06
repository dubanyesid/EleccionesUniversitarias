package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the candidato database table.
 * 
 */
@Entity
@NamedQuery(name="Candidato.findAll", query="SELECT c FROM Candidato c")
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String apellido;

	private String documento;

	private String nombre;

	//bi-directional one-to-one association to Eleccion
	@OneToOne
	@JoinColumn(name="id")
	private Eleccion eleccion;

	//bi-directional one-to-one association to Voto
	@OneToOne(mappedBy="candidato")
	private Voto voto;

	public Candidato() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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