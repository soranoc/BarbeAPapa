package org.Serveur;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.apache.commons.io.FilenameUtils;

@WebServlet("FormulaireBarber")
public class FormulaireBarber extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private OutputStream outStream;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Barber b = new Barber();
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
						b.setNom(fieldvalue);
					}
					if ("prenom".equals(fieldname)) {
						b.setPrenom(fieldvalue);
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
					if ("site".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							b.setSite(fieldvalue);
						}
					}
					if ("mail".equals(fieldname)) {
						b.setMail(fieldvalue);
					}
					if ("tel".equals(fieldname)) {
						b.setTel(fieldvalue);
					}
					if ("fax".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							b.setFax(fieldvalue);
						}
					}
					if ("prestation".equals(fieldname)) {
						b.setTypeDePrestation(fieldvalue);
					}
					if ("description".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							b.setDescription(fieldvalue);
						}
					}
					if ("facebook".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							b.setFacebook(fieldvalue);
						}
					}
					if ("linkedin".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							b.setLinkedIn(fieldvalue);
						}
					}
					if ("google".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							b.setGooglePlus(fieldvalue);
						}
					}
					if ("twitter".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							b.setTwitter(fieldvalue);
						}
					}
					if ("password".equals(fieldname)) {
						b.setMdp(fieldvalue);
					}
					b.setValide(true);
				} else {
					// Process form file field (input type="file").
					String filename = FilenameUtils.getName(item.getName());
					b.setPhoto("/tmp/" + filename);
					InputStream filecontent = item.getInputStream();
					writeFile(filecontent, filename);
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
			int idBarber = Init.getInstance().getBarberDao().insert(b);
			res.sendRedirect("PageProfil?id=" + idBarber);
		}
		
		// Redirection avec attribut

		req.setAttribute("emailconf", emailconf);
		req.setAttribute("passwdconf", passwdconf);
		req.setAttribute("warning", warning);

		RequestDispatcher rd = req.getRequestDispatcher("/formulaire.jsp");
		rd.forward(req, res);
	}

	/*
	private void generateUtilisateur(Utilisateur u, Client c, int idClient) {
		u.setIdt(-1);
		u.setIdClient(idClient);
		u.setMail(c.getMail());
		u.setMdp(c.getMdp());

	}*/

	public void writeFile(InputStream initialStream, String s)
			throws IOException {
		byte[] buffer = new byte[initialStream.available()];
		initialStream.read(buffer);

		File targetFile = new File("/tmp/" + s);
		outStream = new FileOutputStream(targetFile);
		outStream.write(buffer);
	}
}