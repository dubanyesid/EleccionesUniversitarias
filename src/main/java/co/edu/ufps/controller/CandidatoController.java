package co.edu.ufps.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.dao.CandidatoDAO;
import co.edu.ufps.dao.EleccionDAO;
import co.edu.ufps.entities.Candidato;
import co.edu.ufps.entities.Eleccion;


@WebServlet({ "/CandidatoServlet" })
public class CandidatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CandidatoDAO CandidatoDAO;
	private EleccionDAO EleccionDAO;
	
	public CandidatoController() {
		super();
		CandidatoDAO = new CandidatoDAO();
		EleccionDAO = new EleccionDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			if (action == null) {
				listar(request, response);
			} else {
				switch (action) {
				case "index":
					index(request, response);
					break;
				case "register":
					registrar(request, response);
					break;
				case "showedit":
					showEditor(request, response);
					break;
				case "editar":
					editar(request, response);
					break;
				case "eliminar":
					eliminar(request, response);
				default:
					listar(request, response);
				}
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		List<Eleccion> listaEleccion = EleccionDAO.list();
		request.setAttribute("listaEleccion", listaEleccion);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCandidatos/registro.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String documento = request.getParameter("documento");
		int numero = Integer.parseInt(request.getParameter("numero"));
		Eleccion eleccion = EleccionDAO.find(Integer.parseInt(request.getParameter("eleccion")));
		Candidato candidato = new Candidato(apellido, documento, nombre, numero, eleccion);
		CandidatoDAO.insert(candidato);
		this.listar(request, response);
	}

	private void showEditor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Candidato candidato = CandidatoDAO.find(id);
		List<Eleccion> listaEleccion = EleccionDAO.list();
		request.setAttribute("candidato", candidato);
		request.setAttribute("listaEleccion", listaEleccion);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCandidatos/editar.jsp");
		dispatcher.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String documento = request.getParameter("documento");
		int numero = Integer.parseInt(request.getParameter("numero"));
		Eleccion eleccion = EleccionDAO.find(Integer.parseInt(request.getParameter("eleccion").split(" - ")[0]));
		Candidato candidato = new Candidato(apellido, documento, nombre, numero, eleccion);
		candidato.setId(id);
		CandidatoDAO.update(candidato);
		this.listar(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Candidato candidato = CandidatoDAO.find(id);
		CandidatoDAO.delete(candidato);
		listar(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		List<Candidato> listaCandidato = CandidatoDAO.list();
		request.setAttribute("listaCandidato", listaCandidato);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCandidatos/mostrar.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}