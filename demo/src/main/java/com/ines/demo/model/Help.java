package com.ines.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "HELP" database table.
 * 
 */
@Entity
@Table(name="\"HELP\"")
@NamedQuery(name="Help.findAll", query="SELECT h FROM Help h")
public class Help implements Serializable {
	private static final long serialVersionUID = 1L;
	private HelpPK id;
	private String info;

	public Help() {
	}


	@EmbeddedId
	public HelpPK getId() {
		return this.id;
	}

	public void setId(HelpPK id) {
		this.id = id;
	}


	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}