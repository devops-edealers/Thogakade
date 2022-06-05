package lk.ijse.pos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection databaseConnection;
    private Connection connection;
    private static final String HOST="jdbc:mysql://127.0.0.1:3306/Thogakade";
    private static final String USER="root";
    private static final String PASSWORD="1234";

    private DatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection(HOST,USER,PASSWORD);
    }
    public static DatabaseConnection getInstance() throws SQLException, ClassNotFoundException {
        return (databaseConnection==null? (new DatabaseConnection()):databaseConnection);
    }
    public Connection getConnection(){
        return connection;
    }
}
