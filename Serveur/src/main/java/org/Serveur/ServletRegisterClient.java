package org.Serveur;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("ServletRegisterClient")
public class ServletRegisterClient extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

		Client c = new Client();
		String password2 = "";
		String mail2 = "";
		try {
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory()).parseRequest(req);
			for (FileItem item : items) {
				if (item.isFormField()) {
					// Process regular form field
					String fieldname = item.getFieldName();
					String fieldvalue = item.getString();

					if ("mail2".equals(fieldname)) {
						mail2 = fieldvalue;
					}

					if ("password2".equals(fieldname)) {
						password2 = fieldvalue;
					}

					if ("nom".equals(fieldname)) {
						c.setNom(fieldvalue);
					}
					if ("prenom".equals(fieldname)) {
						c.setPrenom(fieldvalue);
					}
					if ("date".equals(fieldname)) {
						c.setDateNaiss(fieldvalue);
					}
					if ("adresse".equals(fieldname)) {
						c.setAdresse(fieldvalue);
					}
					if ("codep".equals(fieldname)) {
						c.setCodePostal(fieldvalue);
					}
					if ("ville".equals(fieldname)) {
						c.setVille(fieldvalue);
					}					
										
					if ("mail".equals(fieldname)) {
						c.setMail(fieldvalue);
					}
					if ("tel".equals(fieldname)) {
						c.setTel(fieldvalue);
					}
					
					
					if ("password".equals(fieldname)) {
						c.setMdp(fieldvalue);
					}
					} 
			}
		} catch (FileUploadException e) {
			throw new ServletException("Cannot parse multipart request.", e);
		}

		// Checkout

		String emailconf = "";
		String passwdconf = "";
		String warning = "";
		boolean checked = true;
		if (!mail2.equals(c.getMail())) {
			emailconf = "has-error";
			warning = "has-warning";
			checked = false;
		}
		if (!password2.equals(c.getMdp())) {
			passwdconf = "has-error";
			warning = "has-warning";
			checked = false;
		}

		// redirection basique
		if (checked == true) {
			Init.getInstance().getClientDao().insert(c);
			res.sendRedirect("accueil.jsp");
		}

		// Redirection avec attribut

		req.setAttribute("emailconf", emailconf);
		req.setAttribute("passwdconf", passwdconf);
		req.setAttribute("warning", warning);

		RequestDispatcher rd = req.getRequestDispatcher("/formulaireClient.jsp");
		rd.forward(req, res);
	}
}

