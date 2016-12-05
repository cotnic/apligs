package com.cotnic.apligs.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.cotnic.apligs.entities.Uporabnik;

/**
 * Servlet implementation class JPAServlet
 */
public class JPAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="apligs-jpa")
	EntityManager em;
	
	@Resource
	UserTransaction tx;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JPAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Query q = em.createNamedQuery("Uporabnik.findId");
		q.setParameter("id", 2);
		Uporabnik uporabnik = (Uporabnik)q.getSingleResult();
		response.getWriter().append("The user that is returned: " + uporabnik.getUpIme() + " " + uporabnik.getUpPriimek() + "<br/>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
