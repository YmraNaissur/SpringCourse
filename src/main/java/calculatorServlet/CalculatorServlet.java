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
 * 18.08.2017
 * Сервлет будет выполнять простейшие арифметические операции и выводить результаты на веб-странице
 * Параметры запроса: числа one и two, а также operation (add, subtract, multiply, divide)
 */
public class CalculatorServlet extends HttpServlet {
    // Здесь будут храниться строки с операциями
    private List<String> operations = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        // Считываем параметры
        int one = Integer.parseInt(req.getParameter("one"));
        int two = Integer.parseInt(req.getParameter("two"));
        String operation = req.getParameter("operation");

        // Определяем или создаем сессию
        HttpSession session = req.getSession(true);
        // Сразу создал аттрибут, чтобы потом не получать NPE при попытке достать его, когда его еще нет
        session.setAttribute("operations", operations);

        int result = 0; // промежуточный результат операций
        String resultingLine = "";   // результирующая строка, которую будем выводить на страницу

        // Получаем промежуточный результат и строку с операцией
        switch (operation) {
            case "add":
                result = one + two;
                operation = "+";
                break;
            case "subtract":
                result = one - two;
                operation = "-";
                break;
            case "multiply":
                result = one * two;
                operation = "*";
                break;
            case "divide":
                result = one / two;
                operation = " : ";
                break;
            default:
                resultingLine = "Unexpected operation.";
        }

        // Фомируем строку вида [число1] [операция] [число2] = [результат],
        // если передана одна из доступных операций
        if (!resultingLine.equals("Unexpected operation.")) {
            resultingLine = getStringForOperation(operation, one, two, result);
        }

        // Если сессия новая, очищаем список
        if (session.isNew()) {
            operations.clear();
        }

        // Добавляем полученную строку в список, а список устанавливаем как атрибут сессии
        operations.add(resultingLine);
        session.setAttribute("operations", operations);

        out.println("<h3>ID ваше сессии: " + session.getId() + "</h3>");
        out.println("<h3>Всего операций: " + operations.size() + "</h3>");

        // Получаем все строки из списка и выводим их
        for (String s: operations) {
            out.println("<p>" + s + "</p>");
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
