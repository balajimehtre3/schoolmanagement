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
import javax.servlet.http.HttpSession;

@WebServlet("/DeletTeacher")
public class DeletTeacher extends HttpServlet{
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	HttpSession hs = req.getSession();
	
	if(hs.getAttribute("EMAIL")==null && hs.getAttribute("PASSWORD")==null)
	{
		PrintWriter w= resp.getWriter();
		w.write("Session Expire Please Login");
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
	else
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("School_Management");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Teacher s = em.find(Teacher.class, Integer.parseInt(req.getParameter("ID")));
		
		et.begin();
		em.remove(s);
		et.commit();
		
		PrintWriter w= resp.getWriter();
		w.write("Teacher Data Deleted");
		RequestDispatcher rd = req.getRequestDispatcher("teacher.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
	}
}
