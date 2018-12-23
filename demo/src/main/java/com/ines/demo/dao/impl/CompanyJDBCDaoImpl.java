package com.ines.demo.dao.impl;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.ines.demo.dao.ICompanyJDBCDao;
import com.ines.demo.model.Company;

import oracle.jdbc.driver.OracleConnection;

@RequestScoped
public class CompanyJDBCDaoImpl extends GenericDao<Company, Long> implements ICompanyJDBCDao {

	@Inject
	Connection connection;
	
	@Override
	public List<Company> getCompanyListByPipeLined() {
		try {
			
			Map<String, Class<?>> map = connection.getTypeMap();
			map.put("COMPANY_TYPE", Company.class);
			connection.setTypeMap(map);
			
			CallableStatement callableStatement = connection.prepareCall("select * from table(get_company_list(tabCompany => ?))");
			
			Array array = connection.unwrap(OracleConnection.class).createOracleArray("COMPANY_TAB_TYPE", Company.getTestDataCompanies().toArray());
			
			callableStatement.setObject("tabCompany", array);
			
			ResultSet resultSet = callableStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getLong(resultSet.findColumn("ID")));
				System.out.println(resultSet.getNString(resultSet.findColumn("COMID")));
				System.out.println(resultSet.getNString(resultSet.findColumn("NAME")));
				System.out.println(resultSet.getNString(resultSet.findColumn("ADDRESS")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Class<Company> getEntityClass() {
		return Company.class;
	}

}
