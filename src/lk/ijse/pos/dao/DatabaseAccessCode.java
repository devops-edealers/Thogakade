package lk.ijse.pos.dao;

import lk.ijse.pos.dto.SystemUserDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
