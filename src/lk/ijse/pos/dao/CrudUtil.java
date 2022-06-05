package lk.ijse.pos.dao;

import lk.ijse.pos.db.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    public static <T> T execute(String sql, Object... params) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection()
                .prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            statement.setObject((i+1), params[i]);
        }
        if (sql.startsWith("SELECT")){
            return (T) statement.executeQuery();
        }
        return (T)(Boolean)(statement.executeUpdate()>0);
    }
}
