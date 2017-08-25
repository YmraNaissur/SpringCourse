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
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            // Получаем все записи таблицы author из БД
            ResultSet rs = stmt.executeQuery("SELECT * FROM author");

            // Заполняем authorList записями из БД
            while (rs.next()) {
                Author a = new Author(rs.getInt("id"), rs.getString("fio"));
                authorList.add(a);
            }
        } catch (SQLException e) {
            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, e);
        }

        return authorList;
    }

    public List<Author> getAuthorList() {
        return authorList.isEmpty() ? getAuthors() : authorList;
    }
}