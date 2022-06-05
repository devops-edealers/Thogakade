package lk.ijse.pos.dao;

import lk.ijse.pos.db.DatabaseConnection;
import lk.ijse.pos.dto.SystemUserDTO;

import java.sql.*;

public class DatabaseAccessCode {
    public boolean createSystemUser(SystemUserDTO dto)
            throws ClassNotFoundException, SQLException {
        Connection connection=DatabaseConnection.getInstance().getConnection();;
        String sql ="INSERT INTO system_user VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,dto.getName());
        statement.setString(2,dto.getEmail());
        statement.setString(3,dto.getPassword());
        return statement.executeUpdate()>0;
    }
    public boolean login(String email, String password) throws ClassNotFoundException, SQLException {
        Connection connection= DatabaseConnection.getInstance().getConnection();
        String sql ="SELECT * FROM system_user WHERE email =? AND password=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,email);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }
}
