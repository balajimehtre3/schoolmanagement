package School_Management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateAccount")
public class School_Management extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Principal principal = new Principal();
		principal.setName(req.getParameter("NAME"));
		principal.setAge(Integer.parseInt(req.getParameter("AGE")));
		principal.setMobile_Number(Long.parseLong(req.getParameter("MOBILE NUMBER")));
		principal.setEmail(req.getParameter("EMAIL"));
		principal.setPassword(req.getParameter("PASSWORD"));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("School_Management");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(principal);
		et.commit();
		
		System.out.println("Data Saved");
		
		PrintWriter w= resp.getWriter();
		w.write("Data Saved");
		RequestDispatcher rd = req.getRequestDispatcher("Navigation.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
}
