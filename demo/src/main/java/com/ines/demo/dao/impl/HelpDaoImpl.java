package com.ines.demo.dao.impl;

import java.sql.Connection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import com.ines.demo.dao.IHelpDao;
import com.ines.demo.model.Help;
import com.ines.demo.model.HelpPK;

public class HelpDaoImpl extends GenericDao<Help, HelpPK> implements IHelpDao {
	
	@Inject
	Connection connection;
	
	@Override
	public List<Help> getHelpList() {
		TypedQuery<Help> query = entityManager.createQuery("SELECT h FROM Help h", Help.class);
		return query.getResultList();
	}

	@Override
	public Class<Help> getEntityClass() {
		return Help.class;
	}

}
