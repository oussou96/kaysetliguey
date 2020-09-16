package sn.isi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.kaysetliguey.dao.IDemandeur;
import sn.kaysetliguey.dao.IUser;
import sn.kaysetliguey.entities.Demandeur;
import sn.kaysetliguey.entities.Employeur;
import sn.kaysetliguey.entities.Job;
import sn.kaysetliguey.entities.User;

/**
 * Servlet implementation class DemandeurServlet
 */
@WebServlet(value="/Demandeur", name="demandeursevlet")
public class DemandeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IDemandeur demandeurdao;
	@EJB
	private IUser userdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandeurServlet() {
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
		int id =Integer.parseInt(request.getParameter("idD").toString());
		switch(action) {
		case "edit":
			Demandeur  dmd = demandeurdao.get(id);
			request.setAttribute("demandeur", dmd);
			break;
		case "delete":
			demandeurdao.delete(id);
			break;
		}
	}
		
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("user", request.getSession().getAttribute("user_session"));
			request.setAttribute("demandeurs", demandeurdao.getAll());
			request.getRequestDispatcher("view/demandeur/liste.jsp").forward(request, response);	
		} 

else {
			response.sendRedirect("Login");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pnom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String age =request.getParameter("age");
		String email = request.getParameter("mail");
		String sexe = request.getParameter("sexe");
		Demandeur dmd = new Demandeur();
		
		dmd.setPnom(pnom);
		dmd.setNom(nom);	
		dmd.setAge(age);
		dmd.setEmail(email);
		dmd.setSexe(sexe);
		

    	if(request.getParameter("id") != null) {// edit
    		
    	int id = Integer.parseInt(request.getParameter("id"));
    	dmd.setId(id);
    	demandeurdao.Update(dmd);
    	
    	} else { // pour ajout 
    		demandeurdao.add(dmd);
    	} 

		
		doGet(request, response);
	}

}
