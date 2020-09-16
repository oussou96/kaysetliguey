package sn.isi.controller;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sn.kaysetliguey.dao.IUser;
import sn.kaysetliguey.entities.Demandeur;
import sn.kaysetliguey.entities.User;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet("/Utilisateur")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private IUser userdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() {
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
		int id =Integer.parseInt(request.getParameter("idU").toString());
		switch(action) {
		case "edit":
			User  u = userdao.get(id);
			request.setAttribute("user", u);
			break;
		case "delete":
			userdao.delete(id);
			break;
		}
	}
	
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("users", userdao.getAll());
			request.getRequestDispatcher("view/admin/liste.jsp").forward(request, response);	
		} else {
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pnom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		String profil = request.getParameter("profil");
		User u = new User();
		
		u.setpNom(pnom);
		u.setNom(nom);
		u.setEmail(email);
		u.setMdp(mdp);
		u.setProfil(profil);
		
		if(request.getParameter("id") != null) {// edit
    		
	    	int id = Integer.parseInt(request.getParameter("id"));
	    	u.setId(id);
	    	userdao.Update(u);
	    	
	    	} else { // pour ajout 
	    		userdao.add(u);
	    	} 
		doGet(request, response);
	}

}
