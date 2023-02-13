package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    public static final String USER_NAME = "postgres";
    public static final String PASSWORD = "Qwerty1";
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String DRIVER = "org.postgresql.Driver";
    public static Connection connection;

    public Util() {
    }

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Таблица успешно подключена");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.setProperty("dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        properties.setProperty("hibernate.connection.url", URL);
        properties.setProperty("hibernate.connection.username", USER_NAME);
        properties.setProperty("hibernate.connection.password", PASSWORD);
        properties.setProperty("hibernate.connection.driver_class", DRIVER);
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return new Configuration().addProperties(properties).addAnnotatedClass(User.class).buildSessionFactory();
    }
}

