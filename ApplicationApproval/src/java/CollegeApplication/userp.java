/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollegeApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class userp extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String emailid=request.getParameter("email");  
         String email = String.valueOf(emailid);
        try
        {
             String ss="jdbc:mysql://localhost:3306/hello";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(ss,"root","");
            PreparedStatement ps=con.prepareStatement("select * from register2 where email=?");  
ps.setString(1,email);  
              
 

  
ResultSet rs=ps.executeQuery();  
            
ResultSetMetaData rsmd=rs.getMetaData();  
int total=rsmd.getColumnCount();
out.print("<html>\n" +
"    <head>\n" +
"        <link href=\"menu.css\" rel=\"stylesheet\" style=\"css/text\" />\n" +
"        \n" +
"     <style>\n" +
"* {box-sizing: border-box;}\n" +
"\n" +
"body {\n" +
"  margin: 10px;\n" +
"  font-family: Arial, Helvetica, sans-serif;\n" +
"}\n" +
"\n" +
".div44\n" +
"{\n" +
"margin-left:400;\n" +
"font-size:20;\n" +
"}\n" +
".topnav {\n" +
"  overflow: hidden;\n" +
"  background-color:gray;\n" +
"  height:60px;\n" +
"  width:400px;\n" +
"}\n" +
"\n" +
"\n" +
"\n" +
"\n" +
".topnav input[type=text] {\n" +
"  float: right;\n" +
"  padding: 6px;\n" +
"  margin-top: 8px;\n" +
"  margin-right: 5px;\n" +
"  border: none;\n" +
"  font-size: 17px;\n" +
"}\n" +
"\n" +
"\n" +
"  .topnav input[type=text] {\n" +
"    border: 1px solid #ccc;  \n" +
"  }\n" +
"body {\n" +
"    background-image: url(\"Stanford.jpg\");\n" +
"    background-repeat: no-repeat;\n" +
"     height: 500px;\n" +
"       background-size: 100% 100%;\n" +
" \n" +
"}\n" +
".dropbtn {\n" +
"    background-color: gray;\n" +
"    color: white;\n" +
"    padding: 16px;\n" +
"    font-size: 16px;\n" +
"    border: none;\n" +
"}\n" +
"\n" +
".dropdown {\n" +
"    position: relative;\n" +
"    display: inline-block;\n" +
"}\n" +
"\n" +
".dropdown-content {\n" +
"    display: none;\n" +
"    position: absolute;\n" +
"    background-color:gray;\n" +
"    min-width: 160px;\n" +
"    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n" +
"    z-index: 1;\n" +
"}\n" +
"\n" +
".dropdown-content a {\n" +
"    color: black;\n" +
"    padding: 12px 16px;\n" +
"    text-decoration: none;\n" +
"    display: block;\n" +
"}\n" +
"\n" +
".dropdown-content a:hover {background-color: #ddd;}\n" +
"\n" +
".dropdown:hover .dropdown-content {display: block;}\n" +
"\n" +
".dropdown:hover .dropbtn {background-color: #ccc;}\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<div id=\"Menu\">\n" +
"<ul>\n" +
"<li><a href=\"firstpage.html\">Home</a></li>\n" +
"\n" +
"<li>\n" +
"    <div class=\"dropdown\">\n" +
"  <button class=\"dropbtn\">Apply for</button>\n" +
"  <div class=\"dropdown-content\">\n" +
"    <a href=\"leaveform.html\">leave</a>\n" +
"    <a href=\"admission.html\">admission</a>\n" +
"    \n" +
"  </div>\n" +
"</div>\n" +
"</li>\n" +
"    \n" +
"<li><a href=\"gallery.html\">gallery</a></li>\n" +
"<li><a href=\"events.html\">events</a></li>\n" +
"<li><a href=\"studentsinfo.html\">student's info</a></li>\n" +
"<li><a href=\"aboutus.html\">About us</a></li>\n" +
"\n" +
"</ul>\n" +
"           \n" +
"  \n" +
"  <div class=\"topnav\">\n" +
"  \n" +
"  <input type=\"text\" placeholder=\"Search..\">\n" +
"  \n" +
"  </div>\n" +
"</div>\n" +
"")
 out.print("<div class=\"div44\" >");
  out.print(" <nav style=\"float:left;\">");
for(int i=1;i<=total;i++)  
{  
out.print("<b>"+rsmd.getColumnName(i)+"</b>"+":"+"<br><br>");  
}  
  out.print("</nav");
 
              
  out.print(" <nav style=\"float:right;\">");
  
while(rs.next())  
{  
out.print("<B>"+rs.getString(1)+"<br><br>"+rs.getString(2)+"<br><br>"+rs.getString(3)+"<br><br>"+rs.getString(4)+"<br><br>"+rs.getString(5)+"</B>");  
                  
}  
 out.print("</nav");

    out.print("   </div>");           
}catch (Exception e2) {e2.printStackTrace();}  
          
finally{out.close();}  
  
}  



// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
