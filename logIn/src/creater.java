import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "creater",urlPatterns = "/creater")
public class creater extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Base manager = (Base) getServletContext().getAttribute("base");
        if ( manager.add(request.getParameter("name"), request.getParameter("password"))) {
            PrintWriter out = response.getWriter();
            out.println("<head>");
            out.println("<title>Welcome</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome "+request.getParameter("name")+"</h1>");
            out.println("</body>");
            out.println("</html>");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<head>");
            out.println("<title>Create Account</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>The Name "+request.getParameter("name")+" is Already in Use </h1>");
            out.println("<a>Please enter another name and password</a>");
            out.println("<form action=\"creater\" method=\"post\">");
            out.println("<p>User Name: <input type=\"text\" name=\"name\" /></p>");
            out.println("<p>Password: <input type=\"password\" name=\"password\" /></p>");
            out.println("<p><input type=\"submit\" value=\"Create Account\"></input></p></form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
