package sn.isi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.kaysetliguey.dao.IDomaine;
import sn.kaysetliguey.entities.Domaine;
import sn.kaysetliguey.entities.Employeur;
import sn.kaysetliguey.entities.Job;

/**
 * Servlet implementation class DomaineServlet
 */
@WebServlet(value="/Domaine", name="domainesevlet")
public class DomaineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private IDomaine domainedao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DomaineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if(request.getSession().getAttribute("user_session") != null) {
	if(request.getParameter("action") != null) {
		String action = request.getParameter("action").toString() ;
		int id =Integer.parseInt(request.getParameter("idDom").toString());
		switch(action) {
		case "edit":
			Domaine  d = domainedao.get(id);
			request.setAttribute("domaine", d);
			break;
		case "delete":
			domainedao.delete(id);
			break;
		}
	}
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("user", request.getSession().getAttribute("user_session"));
			request.setAttribute("domaines", domainedao.getAll());
			request.getRequestDispatcher("view/domaine/liste.jsp").forward(request, response);	
		} else {
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  dm = request.getParameter("domaine");
		Domaine d = new Domaine();
		d.setIntituleDomaine(dm);
		
		if(request.getParameter("id") != null) {// edit
    		
	    	int id = Integer.parseInt(request.getParameter("id"));
	    	d.setId(id);
	    	domainedao.Update(d);
	    	
	    	}  
	    	else { // pour ajout 
	    		domainedao.add(d);
	    	} 
		
		doGet(request, response);
	}

}
