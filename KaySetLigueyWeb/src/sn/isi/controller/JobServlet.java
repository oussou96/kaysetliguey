package sn.isi.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.kaysetliguey.dao.IDomaine;
import sn.kaysetliguey.dao.IJob;
import sn.kaysetliguey.entities.Domaine;
import sn.kaysetliguey.entities.Job;
import sn.kaysetliguey.entities.User;


/**
 * Servlet implementation class JobServlet
 */
@WebServlet(value="/Job", name="jobsevlet")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	@EJB
	private IJob jobdao;
	@EJB
	private IDomaine domainedao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobServlet() {
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
				int id =Integer.parseInt(request.getParameter("idJ").toString());
				switch(action) {
				case "edit":
					Job  b = jobdao.get(id);
					request.setAttribute("job", b);
					break;
				case "delete":
					jobdao.delete(id);
					break;
				}
			}
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("user", request.getSession().getAttribute("user_session"));
		    request.setAttribute("domaines", domainedao.getAll());
			request.setAttribute("jobs", jobdao.getAll());
			
			request.getRequestDispatcher("view/job/liste.jsp").forward(request, response);
			request.getRequestDispatcher("accueil.jsp").forward(request, response);
		} else {
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String emp = request.getParameter("emploi");
		String dateAnnonce = request.getParameter("dateAnnonce");
		String dateFinAnnonce = request.getParameter("dateFinAnnonce");
		String description = request.getParameter("description");
		int idD = Integer.parseInt(request.getParameter("domaine"));
		String lieu = request.getParameter("lieu");
		double salaire = Double.parseDouble(request.getParameter("salaire"));
		Job b = new Job();
		b.setNomJob(emp);
		try {
			b.setDateAnnonce(new SimpleDateFormat("yyyy-MM-dd").parse(dateAnnonce));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		try {
			b.setDateLimit(new SimpleDateFormat("yyyy-MM-dd").parse(dateFinAnnonce));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		b.setJob_desc(description);
		
		b.setLieu(lieu);
		b.setSalaire(salaire);
    	b.setUser((User) request.getSession().getAttribute("user_session"));
    	b.setDomaine(domainedao.get(idD));
    	
    	if(request.getParameter("id") != null) {// edit
    		
    	int id = Integer.parseInt(request.getParameter("id"));
    	b.setId(id);
    	jobdao.Update(b);
    	
    	} else { // pour ajout 
    		jobdao.add(b);	
    	} 
    	
    	
		
		doGet(request, response);
	}

}
