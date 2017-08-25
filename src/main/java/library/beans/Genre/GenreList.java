package library.beans.Genre;

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
 * В этом классе инкапсулировано хранение и получение из БД списка жанров
 */
public class GenreList {
    private List<Genre> genreList = new ArrayList<>();

    private List<Genre> getGenres() {
        Connection conn;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = Database.getConnection();
            stmt = conn.createStatement();
            // Получаем все записи таблицы genre из БД
            rs = stmt.executeQuery("SELECT * FROM genre");

            // Добавляем все полученные записи в список genreList
            while (rs.next()) {
                Genre g = new Genre(rs.getInt("id"), rs.getString("name"));
                genreList.add(g);
            }
        } catch (SQLException e) {
            Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Закрываем Statement и ResultSet
            try {
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return genreList;
    }

    // // Если список авторов пуст, получаем его из БД. Иначе он уже был получен, возвращаем его.
    public List<Genre> getGenreList() {
        return genreList.isEmpty() ? getGenres() : genreList;
    }
}