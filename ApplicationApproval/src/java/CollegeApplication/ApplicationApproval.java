package CollegeApplication ;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ApplicationApproval extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {   
            res.setContentType("text/html");
		 PrintWriter out=res.getWriter();
           
            String s1=req.getParameter("username");
	    String s2=req.getParameter("password");
            
            if(s1.equals("aman") && s2.equals("5L"))
            {
               out.println("Logged In Suceessfully");
            }
            else
            {
             out.println("id & password didnot matched");
            }
    }
       
    }
   
    
