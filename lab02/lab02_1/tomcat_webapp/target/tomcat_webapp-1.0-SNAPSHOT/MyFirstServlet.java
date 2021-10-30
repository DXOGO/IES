import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

@WebServlet(name = "MyFirstServlet", urlPatterns = {"/MyFirstServlet"})
public class MyFirstServlet extends HttpServlet {

    private static final long serialVersionUID = -1915463532411657451L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException
    {
        // i) Get data from URL
        String username = request.getParameter("username");

        // j) Null pointer exception
        //Object abc = null;
        //abc.hashCode();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>IES | Lab 2.1.</title>");
            out.println("</head>");
            out.println("<body>");
            if (username != null) {
                out.println(String.format("<h1>Hello %s!</h1>", username));
                out.println("<p>How are you?</p>");
            } else {
                out.println("<h1>Hello stranger!</h1>");
                out.println("<p>For a personalized experience give your username as a URL parameter!</p>");
                out.println("<p>To do this, just add '?username=YOURUSERNAME' to the URL. ;)</p>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        //Do some other work
    }
}