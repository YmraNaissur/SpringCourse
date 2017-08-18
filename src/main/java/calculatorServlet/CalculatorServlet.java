package calculatorServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * naissur
 * 18.08.2017
 * Сервлет будет выполнять простейшие арифметические операции и выводить результаты на веб-странице
 * Параметры запроса: числа one и two, а также operation (add, subtract, multiply, divide)
 */
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        int one = Integer.parseInt(req.getParameter("one"));
        int two = Integer.parseInt(req.getParameter("two"));
        String operation = req.getParameter("operation");

        int result; // промежуточный результат операций
        String resultingLine;   // результирующая строка, которую будем выводить на страницу

        switch (operation) {
            case "add":
                result = one + two;
                resultingLine = getStringForOperation("+", one, two, result);
                out.println(resultingLine);
                break;
            case "subtract":
                result = one - two;
                resultingLine = getStringForOperation("-", one, two, result);
                out.println(resultingLine);
                break;
            case "multiply":
                result = one * two;
                resultingLine = getStringForOperation("*", one, two, result);
                out.println(resultingLine);
                break;
            case "divide":
                result = one / two;
                resultingLine = getStringForOperation("/", one, two, result);
                out.println(resultingLine);
                break;
            default:
                out.println("Unexpected operation.");
        }
    }

    /**
     * Создание результирующей строки
     * @param operation операция (+, -, * или /)
     * @param one число 1
     * @param two число 2
     * @param result результат
     * @return строка вида [число1] [операция] [число2] = [результат]
     */
    private String getStringForOperation(String operation, int one, int two, int result) {
        return String.format("%d %s %d = %d", one, operation, two, result);
    }
}
