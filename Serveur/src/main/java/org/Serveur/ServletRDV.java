package org.Serveur;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("ServletRDV")
public class ServletRDV extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
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
		out.println("</head>");

		// Debut du corps de la page
		out.println("<body><div class='container'>");
		out.println("<h1 class='text-center'>Rendez-vous pris</h1>");
		out.println("<br><br><h2 class='text-center'>Chez "+barber+", à "+horaire+"</h2>");
		out.println("</div></body></html>");
	}
}
