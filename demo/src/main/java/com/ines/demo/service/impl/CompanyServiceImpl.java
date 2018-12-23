package com.ines.demo.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.ines.demo.dao.ICompanyJDBCDao;
import com.ines.demo.dao.ICompanyJPADao;
import com.ines.demo.model.Company;
import com.ines.demo.service.ICompanyService;

@RequestScoped
public class CompanyServiceImpl implements ICompanyService {

	@Inject
	ICompanyJDBCDao companyJDBCDao;
	@Inject
	ICompanyJPADao companyJPADao;
	
	@Override
	public List<Company> getCompanyListByPipeLinedAndType(String type) {
		if(type.equals("JDBC")) {
			return companyJDBCDao.getCompanyListByPipeLined();
		} else {
			return companyJPADao.getCompanyListByPipeLined();
		}
	}

}
