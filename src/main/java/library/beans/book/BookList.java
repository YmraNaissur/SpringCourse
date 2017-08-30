package library.beans.book;

import library.db.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * naissur
 * 25.08.2017
 * В этом классе инкапсулировано хранение и получение из БД списка книг
 */
public class BookList {
    private List<Book> bookList = new ArrayList<>();

    // Если список книг пуст, получаем его из БД. Иначе он уже был получен, возвращаем его.
    public List<Book> getBookList() {
        return bookList.isEmpty() ? getBooks() : bookList;
    }

    /**
     * Получаем список всех книг из таблицы book
     * @return список, содержащий все книги из таблицы book
     */
    private List<Book> getBooks() {
        return selectBooksByQuery("SELECT * FROM book");
    }

    /**
     * Получаем список книг по автору
     * @param author_id ИД автора книги
     * @return список книг, написанных автором с указанным id
     */
    public List<Book> getBooksByAuthor(long author_id) {
        return selectBooksByQuery("SELECT * FROM library.book WHERE author_id=" + author_id);
    }

    /**
     * Получаем обложку, соответствующую id книги
     * @param id ИД книги
     * @return Объект класса Blob, представляющий собой изображение
     */
    public Blob getImageByBookId(long id) {
        return selectBooksByQuery("SELECT * FROM book WHERE id=" + id).get(0).getImage();
    }

    /**
     * Метод возвращает список книг в соответствии с SQL-запросом
     * @param query SQL-запрос
     * @return список книг, удовлетворяющих SQL-запросу query
     */
    private List<Book> selectBooksByQuery(String query) {
        List<Book> booksByQuery = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = Database.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            // Заполняем booksByQuery записями из таблицы book соответственно переданному запросу
            while (rs.next()) {
                booksByQuery.add(new Book(rs.getInt("id"), rs.getString("name"), rs.getInt("page_count"),
                        rs.getString("isbn"), rs.getBlob("image")));
            }
        } catch (SQLException e) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Закрываем Statement и ResultSet
            try {
                if (conn != null) conn.close();
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return booksByQuery;
    }
}