
package com.wordpress.erenha.java.desktop.entry.dao.impl;

import com.wordpress.erenha.java.desktop.entry.dao.UserLoginDao;
import com.wordpress.erenha.java.desktop.entry.utility.DatabaseUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserLoginDaoImpl.java
 * Implementasi dari interface UserLoginDao 
 * @author Irfan Hidayat Amarulloh
 */
public class UserLoginDaoImpl implements UserLoginDao {

    private Connection connection;
    private final String getUserLoginQuery =
            "SELECT * FROM user_login WHERE username = ? AND password = MD5(?)";

    @Override
    public boolean getUserLogin(String username, String password) throws Exception {
        PreparedStatement statement = null;
        try {
            connection = DatabaseUtility.getConnection();
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(getUserLoginQuery);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            connection.commit();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(true);
            if (statement != null) {
                statement.close();
            }
        }
    }
}
