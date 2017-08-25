package library.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * naissur
 * 25.08.2017
 * Класс для получения соединения с БД
 */
public class Database {
    private static Connection conn;

    /**
     * Получаем соединение с БД.
     * @return объект типа Connection, представляющий собой соединение с БД.
     */
    public static Connection getConnection() {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/library");
            if (conn == null) {
                conn = ds.getConnection();
            }
        } catch (NamingException | SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }

        return conn;
    }
}