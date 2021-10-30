package com.dxogo;
 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "MyFirstServlet", urlPatterns = {"/MyFirstServlet"})
public class MyFirstServlet extends HttpServlet {
 
    private static final long serialVersionUID = -1915463532411657451L;
 
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
            
        String name = request.getParameter("name");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Welcome</title>");
        out.println("</head>");
        out.println("<body>");

        if (name != null) {
            out.println(String.format("<h1>Hey %s!</h1>", name));
            out.println("<p>How you doin? Here is free cookies!</p>");
        } else {
            out.println("<h1>Please state you name for free cookies:<h1>");
            out.println("<p>Add '?name=yourname' to the URL ;)</p>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
     
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}