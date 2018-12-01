package com.ines.demo.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.ines.demo.dao.IHelpDao;
import com.ines.demo.model.Help;
import com.ines.demo.service.IHelpService;

@RequestScoped
public class HelpServiceImpl implements IHelpService {

	@Inject
	IHelpDao helpDao;
	
	@Override
	public List<Help> getHelpList() {
		return helpDao.getHelpList();
	}

}
