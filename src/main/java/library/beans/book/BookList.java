package library.beans.book;

import library.db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    private List<Book> getBooks() {
        Connection conn;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = Database.getConnection();
            stmt = conn.createStatement();
            // Получаем все записи таблицы book из БД
            rs = stmt.executeQuery("SELECT * FROM book");

            // Заполняем bookList записями из таблицы book
            while (rs.next()) {
                Book b = new Book(rs.getInt("id"), rs.getString("name"));
                bookList.add(b);
            }
        } catch (SQLException e) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Закрываем Statement и ResultSet
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return bookList;
    }

    // Если список книг пуст, получаем его из БД. Иначе он уже был получен, возвращаем его.
    public List<Book> getBookList() {
        return bookList.isEmpty() ? getBooks() : bookList;
    }
}