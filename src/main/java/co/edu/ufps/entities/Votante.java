package co.edu.ufps.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the votante database table.
 * 
 */
@Entity
@NamedQuery(name="Votante.findAll", query="SELECT v FROM Votante v")
public class Votante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String documento;

	private String email;

	private String nombre;

	//bi-directional one-to-one association to Eleccion
	@OneToOne
	@JoinColumn(name="id")
	private Eleccion eleccion;

	//bi-directional one-to-one association to Tipodocumento
	@OneToOne
	@JoinColumn(name="id")
	private Tipodocumento tipodocumento;

	//bi-directional one-to-one association to Voto
	@OneToOne(mappedBy="votante")
	private Voto voto;

	public Votante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Tipodocumento getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(Tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public Voto getVoto() {
		return this.voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

}