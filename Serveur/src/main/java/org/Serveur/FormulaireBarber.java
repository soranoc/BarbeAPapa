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

		Barber barber = new Barber();
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
						barber.setNom(fieldvalue);
					}
					if ("prenom".equals(fieldname)) {
						barber.setPrenom(fieldvalue);
					}
					if ("date".equals(fieldname)) {
						barber.setDateNaiss(fieldvalue);
					}
					if ("photo".equals(fieldname)) {
						barber.setPhoto(fieldvalue);
					}
					if ("adresse".equals(fieldname)) {
						barber.setAdresse(fieldvalue);
					}
					if ("codep".equals(fieldname)) {
						barber.setCodePostal(fieldvalue);
					}
					if ("ville".equals(fieldname)) {
						barber.setVille(fieldvalue);
					}
					if ("entreprise".equals(fieldname)) {
						barber.setEntreprise(fieldvalue);
					}
					if ("site".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							barber.setSite(fieldvalue);
						}
					}
					if ("mail".equals(fieldname)) {
						barber.setMail(fieldvalue);
					}
					if ("tel".equals(fieldname)) {
						barber.setTel(fieldvalue);
					}
					if ("fax".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							barber.setFax(fieldvalue);
						}
					}
					if ("prestation".equals(fieldname)) {
						barber.setTypeDePrestation(fieldvalue);
					}
					if ("description".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							barber.setDescription(fieldvalue);
						}
					}
					if ("facebook".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							barber.setFacebook(fieldvalue);
						}
					}
					if ("linkedin".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							barber.setLinkedIn(fieldvalue);
						}
					}
					if ("google".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							barber.setGooglePlus(fieldvalue);
						}
					}
					if ("twitter".equals(fieldname)) {
						if (!fieldvalue.equals("")) {
							barber.setTwitter(fieldvalue);
						}
					}
					if ("password".equals(fieldname)) {
						barber.setMdp(fieldvalue);
					}
					barber.setValide(true);
				} else {
					// Process form file field (input type="file").
					String filename = FilenameUtils.getName(item.getName());
					barber.setPhoto("/tmp/" + filename);
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
		if (!mail2.equals(barber.getMail())) {
			emailconf = "has-error";
			warning = "has-warning";
			checked = false;
		}
		if (!password2.equals(barber.getMdp())) {
			passwdconf = "has-error";
			warning = "has-warning";
			checked = false;
		}

		// redirection basique
		if (checked == true) {
			Init.getInstance().getBarberDao().insert(barber);
			res.sendRedirect("choixrdv.jsp?login=" + mail2);
		}
		
		// Redirection avec attribut

		req.setAttribute("emailconf", emailconf);
		req.setAttribute("passwdconf", passwdconf);
		req.setAttribute("warning", warning);

		RequestDispatcher rd = req.getRequestDispatcher("/formulaireBarber.jsp");
		rd.forward(req, res);
	}

	public void writeFile(InputStream initialStream, String s)
			throws IOException {
		byte[] buffer = new byte[initialStream.available()];
		initialStream.read(buffer);

		File targetFile = new File("/tmp/" + s);
		outStream = new FileOutputStream(targetFile);
		outStream.write(buffer);
	}
}