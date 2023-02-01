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

@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
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
			Teacher teacher = new Teacher();
			teacher.setId(Integer.parseInt(req.getParameter("ID")));
			teacher.setName(req.getParameter("NAME"));
			teacher.setSubject(req.getParameter("SUBJECT"));
			teacher.setSalarys(Double.parseDouble(req.getParameter("SALARY")));

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("School_Management");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();

			et.begin();
			em.persist(teacher);
			et.commit();

			PrintWriter w = resp.getWriter();
			w.write("Teacher Added");
			RequestDispatcher rd = req.getRequestDispatcher("teacher.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}
}
