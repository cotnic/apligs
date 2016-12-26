package si.fri.tpo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import si.fri.prpo.zrna.vmesniki.UpravljalecOglasovSBLocal;
import si.fri.prpo.zrna.vmesniki.UpravljalecSporocilSBLocal;
import si.fri.tpo.model.Ogla;
import si.fri.tpo.model.Sporocilo;
import si.fri.tpo.model.Uporabnik;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UpravljalecSporocilSBLocal sporociloSB;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Sporocilo> sporocila = sporociloSB.vrniVseOglase();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Vsi uporabniki</title></head>");
		out.println("<body>");
		out.println("<center><h1>Vsi uporabniki</h1>");
		out.println("<table border=\"1\" align=\"center\" style=\"width:50%\">");
		out.println("<tr>" + "<th>Geslo</th>" + "<th>Ime</th>" + "<th>Priimek</th>" + "<th>email</th>" + "</tr>");
		for (Sporocilo sporocilo : sporocila) {
			out.println("<tr>");
			System.out.println(sporocilo.getIdSporocila() + " id Sporocila");
			out.print("<td>" + sporocilo.getSpZadeva() + "</td>");
			out.print("<td>" + sporocilo.getSpVsebina() + "</td>");
			out.print("<td>" + sporocilo.getSpPoslano() + "</td>");
			out.print("<td>" + sporocilo.getUporabnik1() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</center>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
