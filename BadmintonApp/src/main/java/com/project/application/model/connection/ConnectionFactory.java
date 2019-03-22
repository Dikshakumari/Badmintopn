package com.project.application.model.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	static Logger logger = Logger.getLogger(ConnectionFactory.class.getName());
	private static Connection connection = null;

	private ConnectionFactory() {
	}

	public static Connection getConnection() {

		if (connection != null)
			return connection;
		else {
			try {
				Properties prop = new Properties();
				InputStream inputStream = ConnectionFactory.class
						.getClassLoader().getResourceAsStream(
								"dbproperty.properties");
				prop.load(inputStream);

				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				Class.forName(driver);
				logger.log(Level.FINE, "driver is loader...");

				connection = DriverManager.getConnection(url, user, password);

			} catch (ClassNotFoundException | SQLException | IOException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
			}

			return connection;
		}
	}
}