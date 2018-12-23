package com.ines.demo.dao;

import java.util.List;

import com.ines.demo.model.Company;

public interface ICompanyJPADao {

	List<Company> getCompanyListByPipeLined();
	
}
