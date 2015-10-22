import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import org.apache.commons.lang3.StringEscapeUtils;


@WebServlet("/servlet/Authen")
public class Authen extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter out = res.getWriter();
	
	res.setContentType("text/html");
	out.println("<html><head><meta charset=UTF-8>");
	out.println("<link rel=stylesheet type=text/css href=style.css>");
	out.println("<title>Test Mdp</title></head>");
	out.println("<body><center>");
	out.println("<h1>Login :</h1>");
	
	String login=StringEscapeUtils.escapeHtml4(req.getParameter("login"));
	String mdp=StringEscapeUtils.escapeHtml4(req.getParameter("mdp"));

	List<Client> l = Init.getInstance().getClientDao().listerClients();
	for(int i;i<l.length();++i){
		if(l.get(i).getMail().equals(login){
			if(l.get(i).getmdp().equals(mdp){
				res.sendRedirect("accueil.jsp");
			}		
		}
		else 
			res.sendRedirect("connexion.jsp");	
	}		    

	out.println("</center></body>");

    }
}
