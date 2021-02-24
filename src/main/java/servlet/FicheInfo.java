package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ficheinfo",
urlPatterns={"/FicheInfo"})
public class FicheInfo extends HttpServlet {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
public void doPost(HttpServletRequest request,
					HttpServletResponse response)
	 throws ServletException, IOException {
	Enumeration<String> enume = request.getParameterNames();
	List<String> list = Collections.list(enume);
    System.out.println(list.toString());
    
	String libelle=request.getParameter("libelle");
	String section=request.getParameter("section");
	
   
	response.setContentType("text/html");

	PrintWriter out = response.getWriter();
	
	
	out.println("<HTML>\n<BODY>\n" +
				"<H1>Recapitulatif des informations</H1>\n" +
				"<UL>\n" +			
		" <LI>libelle: "
				+ libelle + "\n" +
				" <LI>section: "
				+ section + "\n" +
				"</UL>\n" +				
		"</BODY></HTML>");
}
}
