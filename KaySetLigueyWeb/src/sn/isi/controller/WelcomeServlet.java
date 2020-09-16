package sn.isi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.kaysetliguey.dao.IDomaine;
import sn.kaysetliguey.dao.IJob;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IJob jobdao;
	@EJB
	private IDomaine domainedao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user_session") != null) {
			
			request.setAttribute("user", request.getSession().getAttribute("user_session"));
			 request.setAttribute("domaines", domainedao.getAll());
				request.setAttribute("jobs", jobdao.getAll());
				request.getRequestDispatcher("view/job/liste_only.jsp").forward(request, response);
			request.getRequestDispatcher("accueil.jsp").forward(request, response);	
		} else {
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
