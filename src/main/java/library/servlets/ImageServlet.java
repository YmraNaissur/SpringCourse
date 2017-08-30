package library.servlets;

import library.beans.book.BookList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * naissur
 * 30.08.2017
 * Сервлет получает изображение по ссылке вида /imageServlet?id=[id],
 * где [id] - ИД книги, обложку которой необходимо получить
 */
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.valueOf(req.getParameter("id")); // Получили id книги из запроса
        Blob image = new BookList().getImageByBookId(id);   // Получили обложку в виде Blob-объекта

        // Открываем входной и выходной потоки, считываем двоичные данные из входного потока, записываем их в response
        try (InputStream in = image.getBinaryStream(); BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream())) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            // Освобождаем буфер и изображение
            out.flush();
            image.free();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
