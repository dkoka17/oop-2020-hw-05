import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logIn", urlPatterns = "/logIn")
public class logIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Base manager = (Base) getServletContext().getAttribute("base");

        if (manager.check(request.getParameter("name"), request.getParameter("password"))) {
            PrintWriter out = response.getWriter();
            out.println("<head>");
            out.println("<title>Welcome</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome " + request.getParameter("name") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } else {
            String redirectURL = "tryAgain.html";
            response.sendRedirect(redirectURL);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
