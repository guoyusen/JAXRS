package com.ines.demo.model;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the COMPANY database table.
 */
@Entity
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable, SQLData{
	private static final long serialVersionUID = 1L;
	private long id;
	private String address;
	private String comid;
	private String name;

	public Company() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComid() {
		return this.comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getSQLTypeName() throws SQLException {
		return "COMPANY_TYPE";
	}

	@Override
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		id = stream.readLong();
		comid = stream.readNString();
		name = stream.readNString();
		address = stream.readNString();
	}

	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		stream.writeLong(id);
		stream.writeNString(comid);
		stream.writeNString(name);
		stream.writeNString(address);
	}
	
	public static List<Company> getTestDataCompanies() {
		List<Company> companies = new ArrayList<Company>();
		
		for (int i = 1; i < 5; i++) {
			Company company = new Company();
			company.setId(i);
			company.setComid("COM_" + i);
			
			companies.add(company);
		}
		
		return companies;
	}

}