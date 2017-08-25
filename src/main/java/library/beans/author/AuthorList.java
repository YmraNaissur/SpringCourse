package library.beans.author;

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
 * В этом классе инкапсулировано хранение и получение из БД списка авторов
 */
public class AuthorList {
    private List<Author> authorList = new ArrayList<>();

    private List<Author> getAuthors() {
        Connection conn;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = Database.getConnection();
            stmt = conn.createStatement();
            // Получаем все записи таблицы author из БД
            rs = stmt.executeQuery("SELECT * FROM author ORDER BY fio ASC");

            // Заполняем authorList записями из БД
            while (rs.next()) {
                Author a = new Author(rs.getInt("id"), rs.getString("fio"));
                authorList.add(a);
            }
        } catch (SQLException e) {
            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Закрываем Statement и ResultSet
            try {
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return authorList;
    }

    // Если список авторов пуст, получаем его из БД. Иначе он уже был получен, возвращаем его.
    public List<Author> getAuthorList() {
        return authorList.isEmpty() ? getAuthors() : authorList;
    }
}