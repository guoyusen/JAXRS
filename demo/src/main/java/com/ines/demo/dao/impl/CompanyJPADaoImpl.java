package com.ines.demo.dao.impl;

import java.sql.Connection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Query;

import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.platform.database.jdbc.JDBCTypes;
import org.eclipse.persistence.platform.database.oracle.plsql.PLSQLStoredFunctionCall;
import org.eclipse.persistence.platform.database.oracle.plsql.PLSQLrecord;
import org.eclipse.persistence.queries.DataReadQuery;

import com.ines.demo.dao.ICompanyJPADao;
import com.ines.demo.model.Company;

@RequestScoped
public class CompanyJPADaoImpl extends GenericDao<Company, Long> implements ICompanyJPADao {

	@Inject
	Connection connection;
	
	public void back() {
		PLSQLrecord record = new PLSQLrecord();
		record.setTypeName("COMPANY_TYPE");
		record.setCompatibleType("COMPANY_TYPE");
		record.setJavaType(Company.class);
		record.addField("ID", JDBCTypes.BIGINT_TYPE);
		record.addField("COMID", JDBCTypes.VARCHAR_TYPE, 30);
		record.addField("NAME", JDBCTypes.VARCHAR_TYPE, 30);
		record.addField("ADDRESS", JDBCTypes.VARCHAR_TYPE, 30);
		
		PLSQLStoredFunctionCall functionCall = new PLSQLStoredFunctionCall(record);
		functionCall.setProcedureName("GET_COMPANY");

		DataReadQuery dataReadQuery = new DataReadQuery();
		dataReadQuery.setCall(functionCall);
		dataReadQuery.setResultType(DataReadQuery.VALUE);
		
		Query query = ((JpaEntityManager)entityManager.getDelegate()).createQuery(dataReadQuery);
		System.out.println(query.getSingleResult().toString());
	}
	
	@Override
	public List<Company> getCompanyListByPipeLined() {
		//https://stackoverflow.com/questions/3021696/pl-sql-object-types-ora-06530-reference-to-uninitialized-composite-error
		PLSQLrecord record = new PLSQLrecord();
		record.setTypeName("COMPANY_TYPE");
		record.setCompatibleType("COMPANY_TYPE");
		record.setJavaType(Company.class);
		record.addField("ID", JDBCTypes.BIGINT_TYPE);
		record.addField("COMID", JDBCTypes.VARCHAR_TYPE, 30);
		record.addField("NAME", JDBCTypes.VARCHAR_TYPE, 30);
		record.addField("ADDRESS", JDBCTypes.VARCHAR_TYPE, 30);
		
		PLSQLStoredFunctionCall functionCall = new PLSQLStoredFunctionCall(record);
		functionCall.setProcedureName("GET_COMPANY");
		functionCall.addNamedArgument("tmp", record);

		DataReadQuery dataReadQuery = new DataReadQuery();
		dataReadQuery.setCall(functionCall);
		dataReadQuery.addArgument("tmp");
		dataReadQuery.setResultType(DataReadQuery.AUTO);
		
		Query query = ((JpaEntityManager)entityManager.getDelegate()).createQuery(dataReadQuery);
		query.setParameter("tmp", new Company());
		System.out.println(query.getSingleResult().toString());
		return null;
	}

	@Override
	public Class<Company> getEntityClass() {
		return Company.class;
	}

}
