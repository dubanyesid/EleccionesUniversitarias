package co.edu.ufps.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.dao.EleccionDAO;
import co.edu.ufps.dao.EstamentoDAO;
import co.edu.ufps.dao.TipodocumentoDAO;
import co.edu.ufps.dao.VotanteDAO;
import co.edu.ufps.dao.VotoDAO;
import co.edu.ufps.entities.Eleccion;
import co.edu.ufps.entities.Estamento;
import co.edu.ufps.entities.Tipodocumento;
import co.edu.ufps.entities.Votante;
import co.edu.ufps.entities.Voto;
import co.edu.ufps.util.EnviarEmail;

@WebServlet({ "/VotanteServlet" })
public class VotanteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EleccionDAO EleccionDAO;
	private TipodocumentoDAO TipodocumentoDAO;
	private VotanteDAO VotanteDAO;
	EnviarEmail email;

	public VotanteController() {
		super();
		EleccionDAO = new EleccionDAO();
		TipodocumentoDAO = new TipodocumentoDAO();
		VotanteDAO = new VotanteDAO();
		email = new EnviarEmail();
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
		List<Tipodocumento> listaTipoDocumento = TipodocumentoDAO.list();
		for (Tipodocumento tipodocumento : listaTipoDocumento) {
			System.out.println(tipodocumento.getDescripcion());
		}
		request.setAttribute("listaEleccion", listaEleccion);
		request.setAttribute("listaTipoDocumento", listaTipoDocumento);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaVotantes/registro.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		System.out.println("Entra");
		
		String documento = request.getParameter("documento");
		if(VotanteDAO.buscarPorDocumento(request.getParameter("documento"))!=null) {

			request.setAttribute("mensaje", "Ya está inscrita la persona");
			request.getRequestDispatcher("indexVotante.jsp").forward(request, response);
			return ;
		
		}else {
			request.setAttribute("mensaje", "Se pudo inscribir correctamente");
		}
		
		Integer tipodocumento = Integer.parseInt(request.getParameter("tipodocumento").split(" - ")[0]);
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		
		Integer eleccion1 = Integer.parseInt(request.getParameter("eleccion").split(" - ")[0]);
		Eleccion eleccion = EleccionDAO.find(eleccion1);
		Tipodocumento tipoDocumento = TipodocumentoDAO.find(tipodocumento);
		Votante votante = new Votante(documento, email, nombre, eleccion, tipoDocumento);
		String uuid =  UUID.randomUUID().toString().split("-")[0];
		String enlace = "http://localhost:8088/EleccionesUniversitarias/Voto?voto="+uuid;
		
		Date date = new Date();
		Timestamp timestamp2 = new Timestamp(date.getTime());
		  
		Voto voto = new Voto();
		Estamento estamento = new EstamentoDAO().find(Integer.parseInt(request.getParameter("estamento").split(" - ")[0])); 
		voto.setEnlace(enlace);
		voto.setUuid(uuid);
		voto.setFechacreacion(timestamp2);
		voto.setEstamentoBean(estamento);
		votante.setVotos(new ArrayList<Voto>());
		VotoDAO votoDao = new VotoDAO();
		
		votante.addVoto(voto);
		try {
			VotanteDAO.insert(votante);
			this.email.EnviarEmail(votante.getEmail(),"Votación UFPS",enlace);
			votoDao.insert(voto);
			
			System.out.println("a");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		this.listar(request, response);
	}

	private void showEditor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Votante votante = VotanteDAO.find(id);
		List<Eleccion> listaEleccion = EleccionDAO.list();
		List<Tipodocumento> listaTipoDocumento = TipodocumentoDAO.list();
		request.setAttribute("votante", votante);
		request.setAttribute("listaEleccion", listaEleccion);
		request.setAttribute("listaTipoDocumento", listaTipoDocumento);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaVotantes/editar.jsp");
		dispatcher.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String documento = request.getParameter("documento");
		//Eleccion eleccion = EleccionDAO.find(Integer.parseInt(request.getParameter("eleccion")));
		//Tipodocumento tipoDocumento = TipodocumentoDAO.find(Integer.parseInt(request.getParameter("tipodocumento")));
		Votante votante = this.VotanteDAO.find(id);
		if(!documento.equals(votante.getDocumento()) && this.VotanteDAO.buscarPorDocumento(documento)!=null ) {
			request.setAttribute("mensaje", "Ya está inscrita la persona");
			request.getRequestDispatcher("indexVotante.jsp").forward(request, response);
			return ;
		}
		votante.setNombre(nombre);
		votante.setEmail(email);
		votante.setDocumento(documento);
		votante.setId(id);
		VotanteDAO.update(votante);
		this.listar(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Votante votante = VotanteDAO.find(id);
		VotanteDAO.delete(votante);
		listar(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		List<Votante> listaVotante = VotanteDAO.list();
		request.setAttribute("listaVotante", listaVotante);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaVotantes/mostrar.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}