package calculatorServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * naissur
 * 19.08.2017
 */
public class CheckCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        // Получаем или создаем сессию
        HttpSession session = req.getSession(true);
        // Получаем аттрибут
        Object attr = session.getAttribute("operations");

        // Если аттрибут - ArrayList, то преобразовываем его в список
        // И выводим на веб-странце
        if (attr instanceof ArrayList) {
            List operations = (ArrayList) attr;
            out.println("<h3>Список операций:</h3>");
            for (Object o : operations) {
                out.println("<p>" + o + "</p>");
            }
        } else {
            out.println("</h3>Операции не найдены</h3>");
        }
    }
}
