package sn.isi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.kaysetliguey.dao.IDemandeur;
import sn.kaysetliguey.dao.IEmployeur;
import sn.kaysetliguey.entities.Demandeur;
import sn.kaysetliguey.entities.Employeur;
import sn.kaysetliguey.entities.Job;

/**
 * Servlet implementation class EmployeurServlet
 */
@WebServlet(value="/Employeur", name="employeursevlet")
public class EmployeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IEmployeur employeurdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeurServlet() {
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
		int id =Integer.parseInt(request.getParameter("idE").toString());
		switch(action) {
		case "edit":
			Employeur  emp = employeurdao.get(id);
			request.setAttribute("employeur", emp);
			break;
		case "delete":
			employeurdao.delete(id);
			break;
		}
	}
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("user", request.getSession().getAttribute("user_session"));
			request.setAttribute("employeurs", employeurdao.getAll());
			request.getRequestDispatcher("view/employeur/liste.jsp").forward(request, response);	
		} else {
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nemp = request.getParameter("entreprise");
		String mail = request.getParameter("email");
		String adr =request.getParameter("adresse");
		String siteweb = request.getParameter("site");
		Employeur emp = new Employeur();
		
		emp.setnEmp(nemp);
		emp.setEmail(mail);	
		emp.setAdresse(adr);
		emp.setSiteweb(siteweb);
		

    	if(request.getParameter("id") != null) {// edit
    		
    	int id = Integer.parseInt(request.getParameter("id"));
    	emp.setId(id);
    	employeurdao.Update(emp);
    	
    	}  
    	else { // pour ajout 
    		employeurdao.add(emp);
    	} 
		
		
		doGet(request, response);
	}

}
