package sn.isi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.kaysetliguey.dao.ICv;
import sn.kaysetliguey.dao.IDemandeur;
import sn.kaysetliguey.dao.IUser;
import sn.kaysetliguey.entities.Cv;
import sn.kaysetliguey.entities.Demandeur;
import sn.kaysetliguey.entities.Employeur;
import sn.kaysetliguey.entities.User;

/**
 * Servlet implementation class CvServlet
 */
@WebServlet(value="/Cv", name="cvsevlet")
public class CvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ICv cvdao;
	@EJB
	private IDemandeur demandeurdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CvServlet() {
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
		int id =Integer.parseInt(request.getParameter("idCv").toString());
		switch(action) {
		case "edit":
			Cv  cv = cvdao.get(id);
			request.setAttribute("cv", cv);
			break;
		case "delete":
			cvdao.delete(id);
			break;
		}
	}
		
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("user", request.getSession().getAttribute("user_session"));
			request.setAttribute("demandeurs", demandeurdao.getAll());
			request.setAttribute("cvs", cvdao.getAll());
			request.getRequestDispatcher("view/cv/liste.jsp").forward(request, response);	
		} else {
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String exp_pro = request.getParameter("exp_pro");
		String niv_etud = request.getParameter("niv_etud");
		String tel = request.getParameter("tel_pro");
		int idC = Integer.parseInt(request.getParameter("demandeur"));
		Cv cv = new Cv();
		
		cv.setExpPro(exp_pro);
		cv.setNivEtude(niv_etud);
		cv.setTelPro(tel);
		cv.setDemandeur(demandeurdao.get(idC));
		if(request.getParameter("id") != null) {// edit
    		
	    	int id = Integer.parseInt(request.getParameter("id"));
	    	cv.setId(id);
	    	cvdao.Update(cv);
	    	
	    	}  
	    	else { // pour ajout 
	    		cvdao.add(cv);
	    	} 
		
		doGet(request, response);
	}

}
