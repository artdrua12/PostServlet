import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Для того что бы почитать
// https://javarush.com/groups/posts/328-sozdanie-prostogo-veb-prilozhenija-na-servletakh-i-jsp-chastjh-1

public class ServletPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // перенаправляем на страничку
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/corect.jsp");
        // передаем параметры
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (name.equals("Peter") && password.equals("1234")) {
            // устанавливаем атрибуты
            request.setAttribute("name", name);
            // вызываем метод GET
            doGet(request, response);
        } else {
            // перенаправляем на страничку
            response.sendRedirect("views/wrong.jsp");
        }
    }
}
