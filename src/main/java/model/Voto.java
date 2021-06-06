package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the voto database table.
 * 
 */
@Entity
@NamedQuery(name="Voto.findAll", query="SELECT v FROM Voto v")
public class Voto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String enlace;

	@Temporal(TemporalType.DATE)
	private Date fechacreacion;

	@Temporal(TemporalType.DATE)
	private Date fechavoto;

	private String uuid;

	//bi-directional one-to-one association to Candidato
	@OneToOne
	@JoinColumn(name="id")
	private Candidato candidato;

	//bi-directional one-to-one association to Estamento
	@OneToOne
	@JoinColumn(name="id")
	private Estamento estamento;

	//bi-directional one-to-one association to Votante
	@OneToOne
	@JoinColumn(name="id")
	private Votante votante;

	public Voto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnlace() {
		return this.enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechavoto() {
		return this.fechavoto;
	}

	public void setFechavoto(Date fechavoto) {
		this.fechavoto = fechavoto;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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