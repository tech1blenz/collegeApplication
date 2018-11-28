
package CollegeApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aman
 */
public class abmissionform extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        PrintWriter out=res.getWriter();
        String name = req.getParameter("name");
        String fathersname = req.getParameter("fathersname");
        String email = req.getParameter("email");
        String number = req.getParameter("number");
        String tenpercent= req.getParameter("tenpercent");
        String twpercent = req.getParameter("twpercent");
        String pin = req.getParameter("pin");
       
      
        try {
            String ss="jdbc:mysql://localhost:3306/hello";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(ss,"root","");
            Statement s=con.createStatement();
                  String query="insert into leaveform values('"+name+"',"+fathersname+",'"+email+"','"+number+"', '"+tenpercent+"','"+twpercent+"','"+pin+"')";             
                    int count=s.executeUpdate(query);
                     out.print("<body><center><b><font color='blue'></font></b></center></body>");
                    RequestDispatcher rd=req.getRequestDispatcher("firstpage.html");  
                    rd.include(req, res); 
                    
        } catch (Exception ex ) {
            ex.getMessage();
        }
    }
}