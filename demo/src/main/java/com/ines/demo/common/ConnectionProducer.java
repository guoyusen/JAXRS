package com.ines.demo.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

@Singleton
@Provider
public class ConnectionProducer {
	
	private DataSource dataSource;

	@PostConstruct
	public void initDatasource() {
		try {
			InitialContext ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDataSource");  
		} catch (NamingException e) {
			e.printStackTrace();
		}  
	}
	
	@ApplicationScoped
	@Produces
	public Connection getConnection() {
		System.out.println("=================================");
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
