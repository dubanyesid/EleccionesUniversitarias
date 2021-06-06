package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the eleccion database table.
 * 
 */
@Entity
@NamedQuery(name="Eleccion.findAll", query="SELECT e FROM Eleccion e")
public class Eleccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fechafin;

	@Temporal(TemporalType.DATE)
	private Date fechainicio;

	private String nombre;

	//bi-directional one-to-one association to Candidato
	@OneToOne(mappedBy="eleccion")
	private Candidato candidato;

	//bi-directional one-to-one association to Estamento
	@OneToOne(mappedBy="eleccion")
	private Estamento estamento;

	//bi-directional one-to-one association to Votante
	@OneToOne(mappedBy="eleccion")
	private Votante votante;

	public Eleccion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Candidato getCandidato() {
		return this.candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Estamento getEstamento() {
		return this.estamento;
	}

	public void setEstamento(Estamento estamento) {
		this.estamento = estamento;
	}

	public Votante getVotante() {
		return this.votante;
	}

	public void setVotante(Votante votante) {
		this.votante = votante;
	}

}