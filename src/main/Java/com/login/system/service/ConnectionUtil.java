package com.login.system.service;

import com.login.system.database.DataBaseService;
import com.login.system.database.MySqlDatabaseServiceImpl;

import java.sql.Connection;

public class ConnectionUtil {

    public static String checkConnectionOnStartUp() {
        DataBaseService dataBaseService = new MySqlDatabaseServiceImpl();
        Connection connection = null;
        try {
            connection = dataBaseService.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return "System Error. Please Check Logs: " + e.getMessage();
        }

        if (null == connection) {
            return "System Error. Could not establish connection";
        }

        return "Application Initialized Successfully!";
    }
}
