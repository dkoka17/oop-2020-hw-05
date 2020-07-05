package shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCart",urlPatterns = "/cart")
public class ServletCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cart cur=(cart) request.getSession().getAttribute("cart");
        String id = request.getParameter("id");
        product product = sql.get(id);
        cur.addProduct(product);
        String redirectURL = "wall.jsp";
        response.sendRedirect(redirectURL);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
