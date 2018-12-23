package com.ines.demo.dao.impl;

import java.util.List;

import com.ines.demo.dao.ICompanyJPADao;
import com.ines.demo.model.Company;

public class CompanyJPADaoImpl extends GenericDao<Company, Long> implements ICompanyJPADao {

	@Override
	public List<Company> getCompanyListByPipeLined() {
		return null;
	}

	@Override
	public Class<Company> getEntityClass() {
		return Company.class;
	}

}
