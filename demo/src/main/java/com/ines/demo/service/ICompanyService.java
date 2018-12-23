package com.ines.demo.service;

import java.util.List;

import com.ines.demo.model.Company;

public interface ICompanyService {

	List<Company> getCompanyListByPipeLinedAndType(String type);
	
}
