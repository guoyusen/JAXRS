package com.ines.demo.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

@Provider
@Singleton
public class ConnectionProducer {
	
	private DataSource dataSource;

	public void initDatasource() {
		InitialContext ctx = null;
		try {
			ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDataSource");  
		} catch (NamingException e) {
			e.printStackTrace();
		}  
	}
	
	@ApplicationScoped
	@Produces
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
