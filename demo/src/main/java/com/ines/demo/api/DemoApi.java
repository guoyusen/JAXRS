package com.ines.demo.api;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.ines.demo.model.Help;
import com.ines.demo.model.User;
import com.ines.demo.service.IHelpService;

@RequestScoped
@Path("/api")
public class DemoApi {
	
	@Inject
	IHelpService helpService;

	@GET
	@Path("/json/user")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserInJSON() {
		return getExampleOfUser();
	}

	@GET
	@Path("/json/userByName/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserInJSON(@PathParam("name") String username) {
		return getExampleOfUser(username);
	}

	@GET
	@Path("/json/userByNameRoot/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public JAXBElement<User> getUserInJSON2(@PathParam("name") String username) {
		JAXBElement<User> result = new JAXBElement<User>(new QName("", "root"), User.class, getExampleOfUser(username));
		return result;
	}

	@GET
	@Path("/json/user/cdi/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getProductXML(@PathParam("name") User user) {
		return user;
	}

	@POST
	@Path("/json/adduser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User addBookJSON(User user) {
		return user;
	}

	private User getExampleOfUser() {
		return getExampleOfUser("Alice");
	}

	private User getExampleOfUser(String username) {
		User user = new User();
		user.setName(username);
		user.setAge(12);
		user.setAddress("China");

		return user;
	}
	
	@GET
	@Path("/json/helps")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Help> getHelpList() {
		return helpService.getHelpList();
	}

}
