

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lumpofyums.ConnectionPro;
import lumpofyums.User;
import lumpofyums.UserDatabase;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//feth data from login form
        
        String logusername = request.getParameter("username");
        String logpass = request.getParameter("password");
        
        UserDatabase db =  new UserDatabase(ConnectionPro.getConnection());
        User user = db.login(logusername, logpass);
      
        
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("logUser", user);
            session.setAttribute("logUser1", user.getUserName());
            response.sendRedirect("account.jsp");
        }else{
            System.out.println("user not found");
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Username or password incorrect');");
            pw.println("location='login.jsp';");
            pw.println("</script>");
            RequestDispatcher rd=request.getRequestDispatcher("http://localhost:8090/lumpofyums/login.jsp");
            rd.include(request, response);
		doGet(request, response);
	}
	}

}
