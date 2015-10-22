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

@WebServlet("RegisterClient")
public class ServletRegisterBarber extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

		Barber b = new Barber();
		String password2 = "";
		String mail2 = "";
		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
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
						b.setNom(fieldvalue);
					}
					if ("prenom".equals(fieldname)) {
						b.setPrenom(fieldvalue);
					}
					if("photo".equals(fieldname)) {
						b.setPhoto(fieldvalue);
					}
					if ("date".equals(fieldname)) {
						b.setDateNaiss(fieldvalue);
					}
					if ("adresse".equals(fieldname)) {
						b.setAdresse(fieldvalue);
					}
					if ("codep".equals(fieldname)) {
						b.setCodePostal(fieldvalue);
					}
					if ("ville".equals(fieldname)) {
						b.setVille(fieldvalue);
					}
					if ("date".equals(fieldname)) {
						b.setDateNaiss(fieldvalue);
					}
					if ("entreprise".equals(fieldname)) {
						b.setEntreprise(fieldvalue);
					}
												
					if ("mail".equals(fieldname)) {
						b.setMail(fieldvalue);
					}
					if ("tel".equals(fieldname)) {
						b.setTel(fieldvalue);
					}
					if ("site".equals(fieldname)) {
						b.setSite(fieldvalue);
					}
					if ("fax".equals(fieldname)) {
						b.setFax(fieldvalue);
					}
					if ("profession".equals(fieldname)) {
						b.setTypeDePrestation(fieldvalue);
					}
					if ("description".equals(fieldname)) {
						b.setDescription(fieldvalue);
					}
					
					
					if ("password".equals(fieldname)) {
						b.setMdp(fieldvalue);
					}
					b.setValide(true);
					
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
		if (!mail2.equals(b.getMail())) {
			emailconf = "has-error";
			warning = "has-warning";
			checked = false;
		}
		if (!password2.equals(b.getMdp())) {
			passwdconf = "has-error";
			warning = "has-warning";
			checked = false;
		}

		// redirection basique
		if (checked == true) {
			Init.getInstance().getBarberDao().insert(b);
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

