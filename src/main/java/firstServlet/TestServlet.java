package firstServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * naissur
 * 15.08.2017
 */
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Test Servlet</title>");
        out.println("<link rel='stylesheet' type='text/css' href='" + req.getContextPath() + "/styles/mainStyle.css' media='screen' />");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello, my dear friend</h1>");
        out.println("<p><img src='" + req.getContextPath() + "/images/01.jpg' /></p>");
        out.println("<p><img src='" + req.getContextPath() + "/images/02.jpg' /></p>");
        out.println("<p><img src='" + req.getContextPath() + "/images/03.jpg' /></p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
