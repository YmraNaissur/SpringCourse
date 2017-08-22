package calculatorServlet;

import calculatorServlet.classes.TestObject;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * naissur
 * 19.08.2017
 */
public class CheckCalculatorServlet extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        // Получаем или создаем сессию
        HttpSession session = req.getSession(true);
        // Получаем контекст сервлета
        ServletContext context = getServletContext();
        // Получаем аттрибут operations
        Object attr = session.getAttribute("operations");

        out.println("<table border='1'>");
        out.println("<tr><td>");

        // В левом столбце выводим операции текущего клиента
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

        out.println("</td><td>");

        // В правом столбце выводим операции всех клиентов
        Map<String, List<String>> operationsMap = (Map<String, List<String>>) context.getAttribute("operationsMap");

        for (String sID : operationsMap.keySet()) {
            out.println("<h3><font color='green'>" + sID + "</font></h3>");
            for (String op : operationsMap.get(sID)) {
                out.println("<p>" + op + "</p>");
            }
        }
        out.println("</td></table>");

        // Выводим в консоль значение поля name объекта TestName,
        // который был добавлен в качестве аттрибута контекста в классе CalculatorServlet
        System.out.println("В классе CheckCalculatorServlet: " + ((TestObject)getServletContext().getAttribute("obj")).getName());
        // Вывод будет осуществлен только после отработки сервлета CalculatorServlet,
        // т.к. аттрибут контекста мы добавляем в нем
    }
}
