package CollegeApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Aman
 */
public class forgetpassword extends HttpServlet {

     @Override
     
     protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();    
        String s1=request.getParameter("name");  
        String s2=request.getParameter("ans"); 
        
        try
        {
             String ss="jdbc:mysql://localhost:3306/hello";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(ss,"root","");
            Statement s=con.createStatement();
            String query="select * from register2 where name='"+s1+"' and ans='"+s2+"'";
            ResultSet r=s.executeQuery(query);
            
            while(r.next())
            {
                String u=r.getString("name");
                String p=r.getString("ans");
                if(u.equals(s1) && p.equals(s2))
                {
            RequestDispatcher rd=request.getRequestDispatcher("firstpage.html");  
            rd.forward(request, response);      
        }
                   // out.close();
            }
            out.print("<body><center><b><font color='green'>Incorrect Username or answer</font></b></center></body>");
                    RequestDispatcher rd=request.getRequestDispatcher("forgot.html");  
                    rd.include(request, response);    
                    //response.sendRedirect("Login.html");
        } catch (Exception ex) {
               
         }      
    } 
         }  
