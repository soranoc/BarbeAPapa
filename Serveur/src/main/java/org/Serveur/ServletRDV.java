package org.Serveur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.Barber;
import bdd.Init;
import bdd.Rdv;

@WebServlet("ServletRDV")
public class ServletRDV extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		int idClient = 1;
		int idBarber = -1;
		String mail = req.getParameter("mail");
		Barber b = Init.getInstance().getBarberDao().getByMail(mail);
		idBarber = b.getIdt();
		String barber = req.getParameter("barbier");
		String horaire = req.getParameter("horaire");
		
		out.println("<html><head>");
		out.println("<meta charset='utf-8'>");

		out.println("<script src=\"//code.jquery.com/jquery-1.11.2.min.js\"></script>");
		out.println("<script src=\"//code.jquery.com/jquery-migrate-1.2.1.min.js\"></script>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css\">");
		out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js\"></script>");
		out.println("<br><br><br><title>Rendez-vous pris</title>");
		out.println("<link rel=\"stylesheet\" href=\"style.css\">");
		out.println("</head>");

		// Debut du corps de la page
		out.println("<body><div class='container'>");
		out.println("<img id=\"header\" src=\"http://img15.hostingpics.net/pics/270845pinkmoustache.png\"/>");
		out.println("<br><h1 class='text-center'>Rendez-vous pris</h1>");
		out.println("<br><h2 class='text-center'>Chez "+barber+", à "+horaire+"</h2>");
		out.println("</div></body></html>");
		Init.getInstance().getRdvDao().insert(new Rdv(-1, idClient, idBarber, "DATE", horaire));
	}
}
