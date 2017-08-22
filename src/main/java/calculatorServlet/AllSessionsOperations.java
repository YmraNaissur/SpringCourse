package calculatorServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * naissur
 * 22.08.2017
 * Сервлет, отображающий на странице список операций всех клиентов, обращавшихся к нему.
 * В левой части вывода - операции клиентов, в правой - session id клиентов.
 */
public class AllSessionsOperations extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>Операции</th>");
        out.println("<th>Session ID</th>");
        out.println("</tr>");

        ServletContext context = getServletContext();
        Map<String, List<String>> operationsMap = (Map<String, List<String>>) context.getAttribute(CalculatorServlet.OPERATIONS_MAP);

        for (String sID: (operationsMap.keySet())) {
            out.println("<tr><td>");
            for (String op : operationsMap.get(sID)) {
                out.println(op + "<br />");
            }
            out.println("</td>");
            out.println("<td>" + sID + "</td></tr></table>");
        }
    }
}
