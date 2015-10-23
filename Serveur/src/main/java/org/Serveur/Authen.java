package org.Serveur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("Authen")
public class Authen extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter out = res.getWriter();
	
	res.setContentType("text/html");
	out.println("<html><head><meta charset=UTF-8>");
	out.println("<link rel=stylesheet type=text/css href=style.css>");
	out.println("<title>Test Mdp</title></head>");
	out.println("<body><center>");
	out.println("<h1>Login :</h1>");
	
	String login=req.getParameter("login");
	String mdp=req.getParameter("mdp");

	List<Client> clients = Init.getInstance().getClientDao().listerClients();
	List<Barber> barbers = Init.getInstance().getBarberDao().listerBarbers();
	for(int i=0;i<clients.size();++i){
		if(clients.get(i).getMail().equals(login)){
			if(clients.get(i).getMdp().equals(mdp)){
				res.sendRedirect("choixrdv.jsp?login="+login);
			}		
		}
	}
	for(int i=0;i<barbers.size();++i){
		if(barbers.get(i).getMail().equals(login)){
			if(barbers.get(i).getMdp().equals(mdp)){
				res.sendRedirect("choixrdv.jsp?login="+login);
			}		
		}
	}
	res.sendRedirect("connexion.jsp");	
	out.println("</center></body>");

    }
}
