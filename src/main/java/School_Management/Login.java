package School_Management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("School_Management");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select a from Principal a where a.Email = ?1 and a.Password = ?2");
		q.setParameter(1, req.getParameter("EMAIL"));
		q.setParameter(2, req.getParameter("PASSWORD"));
		
		List<Principal> l  = q.getResultList();
		
		if(l.size()>0)
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("EMAIL", req.getParameter("EMAIL"));
			hs.setAttribute("PASSWORD", req.getParameter("PASSWORD"));
			
			RequestDispatcher rd = req.getRequestDispatcher("Final.html");
			rd.forward(req, resp);
			resp.setContentType("text/html");
		}
		else
		{
			PrintWriter w= resp.getWriter();
			w.write("Invalid Input");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}
}
