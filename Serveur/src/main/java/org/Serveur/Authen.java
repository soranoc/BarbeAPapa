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

	List<Client> l = Init.getInstance().getClientDao().listerClients();
	for(int i=0;i<l.size();++i){
		if(l.get(i).getMail().equals(login)){
			if(l.get(i).getMdp().equals(mdp)){
				res.sendRedirect("choixrdv.jsp?login="+login);
			}		
		}
	}		    
	res.sendRedirect("connexion.jsp");	
	out.println("</center></body>");

    }
}
