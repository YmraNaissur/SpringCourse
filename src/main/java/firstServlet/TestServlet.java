package firstServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * naissur
 * 15.08.2017
 */
public class TestServlet extends HttpServlet {

    private int count;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println(config.getInitParameter("name"));
        System.out.println(config.getInitParameter("age"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        count++;
        req.getSession().setAttribute("count", count);

        PrintWriter out = resp.getWriter();

        // Выводим веб-страницу
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Test Servlet</title>");
        out.println("<link rel='stylesheet' type='text/css' href='" + req.getContextPath() + "/styles/mainStyle.css' media='screen' />");
        out.println("</head>");
        out.println("<body>");

        // Выводим имена и значения параметров на веб-странице
        Enumeration paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String param = paramNames.nextElement().toString();
            out.println("<p>" + param + " = " + req.getParameter(param) + "</p>");
        }

        out.println("<p>" + req.getSession().getAttribute("count") + "</p>");

        out.println("<h1>Hello, " + req.getParameter("p1") + "</h1>");
        out.println("<p><img src='" + req.getContextPath() + "/images/01.jpg' /></p>");
        out.println("<p><img src='" + req.getContextPath() + "/images/02.jpg' /></p>");
        out.println("<p><img src='" + req.getContextPath() + "/images/03.jpg' /></p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
