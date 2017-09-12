package library.beans.book;

import library.db.Database;
import library.enums.SearchType;
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
        return selectBooksByQuery("SELECT b.id,b.name,b.content,b.page_count,b.isbn,b.publish_year,"
                + "a.fio as author,g.name as genre,p.name as publisher,b.image FROM book b "
                + "INNER JOIN author a ON b.author_id=a.id "
                + "INNER JOIN genre g ON b.genre_id=g.id "
                + "INNER JOIN publisher p ON b.publisher_id=p.id "
                + "ORDER BY b.name;");
    }

    /**
     * Получаем список книг по автору
     * @param author_id ИД автора книги
     * @return список книг, написанных автором с указанным id
     */
    public List<Book> getBooksByAuthor(long author_id) {
        return selectBooksByQuery("SELECT b.id,b.name,b.content,b.page_count,b.isbn,b.publish_year,"
                + "a.fio as author,g.name as genre,p.name as publisher,b.image FROM book b "
                + "INNER JOIN author a ON b.author_id=a.id "
                + "INNER JOIN genre g ON b.genre_id=g.id "
                + "INNER JOIN publisher p ON b.publisher_id=p.id "
                + "WHERE author_id=" + author_id + " ORDER BY b.name;");
    }

    /**
     * Получаем список книг по первой букве в названии
     * @param letter первая буква в названии
     * @return список книг, у которых в названии первая буква равна letter
     */
    public List<Book> getBooksByFirstLetter(String letter) {
        return selectBooksByQuery("SELECT b.id,b.name,b.content,b.page_count,b.isbn,b.publish_year,"
                + "a.fio as author,g.name as genre,p.name as publisher,b.image FROM book b "
                + "INNER JOIN author a ON b.author_id=a.id "
                + "INNER JOIN genre g ON b.genre_id=g.id "
                + "INNER JOIN publisher p ON b.publisher_id=p.id "
                + "WHERE SUBSTR(b.name,1,1)='" + letter + "' ORDER BY b.name;");
    }

    /**
     * Получаем список книг, соответствующих поисковому запросу
     * @param request поисковый запрос
     * @param type тип поиска (в названиях, в авторах)
     * @return список книг, удовлетворяющих поисковому запросу
     */
    public List<Book> getBooksBySearch(String request, SearchType type) {
        String sqlQuery = "SELECT b.id,b.name,b.content,b.page_count,b.isbn,b.publish_year,"
                + "a.fio as author,g.name as genre,p.name as publisher,b.image FROM book b "
                + "INNER JOIN author a ON b.author_id=a.id "
                + "INNER JOIN genre g ON b.genre_id=g.id "
                + "INNER JOIN publisher p ON b.publisher_id=p.id ";

        if (type.equals(SearchType.AUTHOR)) {
            sqlQuery += "WHERE LOWER(a.fio) LIKE '%" + request.toLowerCase() + "%' ORDER BY b.name;";
        } else if (type.equals(SearchType.TITLE)) {
            sqlQuery += "WHERE LOWER(b.name) LIKE '%" + request.toLowerCase() + "%' ORDER BY b.name;";
        }

        return selectBooksByQuery(sqlQuery);
    }

    /**
     * Получаем обложку, соответствующую id книги
     * @param id ИД книги
     * @return Объект класса Blob, представляющий собой изображение
     */
    public Blob getImageByBookId(long id) {
        return selectBooksByQuery("SELECT b.id,b.name,b.content,b.page_count,b.isbn,b.publish_year,b.image,"
                + "b.genre_id as genre,b.author_id as author,b.publisher_id as publisher "
                + "FROM book b WHERE id=" + id).get(0).getImage();
    }

    /**
     * Получаем содержимое книги с определенным id
     * @param id ИД книги
     * @return Объект класса Blob, представляющий собой содержимое
     */
    public Blob getContentByBookId(long id) {
        return selectBooksByQuery("SELECT b.id,b.name,b.content,b.page_count,b.isbn,b.publish_year,b.image,"
                + "b.genre_id as genre,b.author_id as author,b.publisher_id as publisher" +
                " FROM book b WHERE id=" + id).get(0).getContent();
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
                booksByQuery.add(new Book(rs.getInt("id"), rs.getString("name"), rs.getBlob("content"),
                        rs.getInt("page_count"), rs.getString("isbn"), rs.getString("genre"),
                        rs.getString("author"), rs.getDate("publish_year"), rs.getString("publisher"),
                        rs.getBlob("image")));
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