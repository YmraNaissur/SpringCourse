package library.servlets;

import library.beans.book.BookList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * naissur
 * 10.09.2017
 */
public class ProcessContent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf");

        long id = Long.valueOf(req.getParameter("id")); // Получили id книги из запроса
        Blob content = new BookList().getContentByBookId(id);   // Получили контент по id

        // Открываем входной и выходной потоки, считываем двоичные данные из входного потока, записываем их в response
        try (InputStream in = content.getBinaryStream(); BufferedOutputStream out =
                new BufferedOutputStream(resp.getOutputStream())) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            // Выталкиваем буфер
            out.flush();
            content.free();
        } catch (SQLException e) {
            Logger.getLogger(ProcessContent.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
