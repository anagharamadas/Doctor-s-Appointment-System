package com.login.system.database;

import com.login.system.constants.DatabaseProperties;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDatabaseServiceImpl implements DataBaseService {
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DatabaseProperties.DRIVER);
            connection = DriverManager.getConnection(
                    DatabaseProperties.URL, DatabaseProperties.USERNAME, DatabaseProperties.PASSWORD);
        } catch (Exception e) {
            System.out.println(e);
        }

        return connection;
    }
}
