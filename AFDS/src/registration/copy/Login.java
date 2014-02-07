package registration.copy;

import model.UserProfile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html>" );
        out.println( "<head><title>Login</title></head>" );
        out.println( "<body>" );

        out.println( "<form action='Login' method='post'>" );
        out.println( "Username: <input type='text' name='username' /> <br />" );
        out.println( "Password: <input type='password' name='password' /> <br />" );
        out.println( "<input type='submit' name='login' value='Login' /> <br />" );
        out.println( "</form>" );
        
        out.println("<p>No Login? <a href='Registration'>Register</a></p>");


        out.println( "</body></html>" );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	@SuppressWarnings("unchecked")
		List<UserProfile> userList = (ArrayList<UserProfile>) getServletContext().getAttribute(
	            "userList");
    	
    	String username = request.getParameter( "username" );
    	String password = request.getParameter( "password" );
    	
    	for (UserProfile user: userList){
    		String userNameTemp = user.getUsername();
    		String passwordTemp = user.getPassword();
    		
    		if(username.equals(userNameTemp) && password.equals(passwordTemp)){
    			request.getSession().setAttribute( "userName", username );
                response.sendRedirect( "MainMod.jsp" );	
                return;
    		}
    	}
    	
            response.sendRedirect( "Login" );
        
    }

}
