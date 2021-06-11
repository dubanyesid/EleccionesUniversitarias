package co.edu.ufps.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.dao.VotoDAO;
import co.edu.ufps.entities.Voto;

/**
 * Servlet implementation class VotoController
 */
@WebServlet({"/VotoServlet","/Voto"})
public class VotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	VotoDAO votoDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotoController() {
        super();
    votoDao = new VotoDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uuid = request.getParameter("voto") ;
		Voto v = null;
		if(uuid == null || uuid.isEmpty() || (v = votoDao.buscarPorUUID(uuid)) == null)  {
			response.getWriter().append("<h1>URL invalid  :( </h1>");
			return ;
		}
		request.setAttribute("votante",v.getVotanteBean());
		request.getRequestDispatcher("vistaVotantes/voto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
