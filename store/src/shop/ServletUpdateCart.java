package shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletUpdateCart",urlPatterns = "/UpdateCart")
public class ServletUpdateCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        cart cart = (cart) request.getSession().getAttribute("cart");
        Enumeration<String> Enum = request.getParameterNames();
        while (Enum.hasMoreElements()) {
            String name = Enum.nextElement();
            int newAmount = Integer.parseInt(request.getParameter(name));
            product product = sql.getByName(name);
            cart.change(product,newAmount);
        }
        request.getRequestDispatcher("/wall.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
