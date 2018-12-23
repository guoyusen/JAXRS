package com.ines.demo.api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.ines.demo.service.ICompanyService;

@RequestScoped
@Path("/api")
public class CompanyApi {
	
	@Inject
	ICompanyService companyService;
	
	@GET
	@Path("/companies")
	public void getCompanyListByPipeLinedAndType(@QueryParam("type") String type) {
		companyService.getCompanyListByPipeLinedAndType(type);
	}
	
}
