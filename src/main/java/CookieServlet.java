

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		boolean isSet = false;
		Cookie cookies[] = request.getCookies();
		if( cookies != null) {
			for( Cookie cookie: cookies) {
				if( cookie.getName().equals("username")) {
					isSet = true;
//					RequestDispatcher rd = request.getRequestDispatcher("CookieHome.jsp");
//					rd.forward(request, response);
					response.sendRedirect("CookieHome.jsp");
				}
			}
		}
		if( !isSet) {
			response.sendRedirect("CookieForm.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String username = request.getParameter("username");
		response.addCookie(new Cookie("username", username));
		response.sendRedirect("CookieHome.jsp");
//		RequestDispatcher rd = request.getRequestDispatcher("CookieHome.jsp");
//		rd.include(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
