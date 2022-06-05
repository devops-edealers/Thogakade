package lk.ijse.pos.dao;

import lk.ijse.pos.dto.SystemUserDTO;

import java.sql.*;

public class DatabaseAccessCode {
    public boolean createSystemUser(SystemUserDTO dto)
            throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection=
                DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/Thogakade",
                        "root",
                        "1234");
        String sql ="INSERT INTO system_user VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,dto.getName());
        statement.setString(2,dto.getEmail());
        statement.setString(3,dto.getPassword());
        return statement.executeUpdate()>0;
       /* int saved = statement.executeUpdate();
        if (saved>0){
            return true;
        }
        return false;*/
    }
    public boolean login(String email, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection=
                DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/Thogakade",
                        "root",
                        "1234");
        String sql ="SELECT * FROM system_user WHERE email =? AND password=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,email);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }
}
