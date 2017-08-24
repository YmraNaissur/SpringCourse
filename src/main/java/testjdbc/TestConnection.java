package testjdbc;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * naissur
 * 24.08.2017
 * Тест соединения с базой данных
 */
public class TestConnection {
    public void check() {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/library");
            Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            // Просто выведем в консоль названия всех книг из БД
            ResultSet rs = stmt.executeQuery("select * from library.book");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }

    }
}