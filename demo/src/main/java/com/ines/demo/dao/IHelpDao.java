package com.ines.demo.dao;

import java.util.List;

import com.ines.demo.model.Help;
import com.ines.demo.model.HelpPK;

public interface IHelpDao extends IGenericDao<Help, HelpPK> {

	List<Help> getHelpList();
	
}
