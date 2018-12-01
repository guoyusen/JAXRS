package com.ines.demo;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ines.demo.api.DemoApi;

@ApplicationScoped
@ApplicationPath("/*")
public class DemoApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> rrcs = new HashSet<Class<?>>();
		rrcs.add(DemoApi.class);
		return rrcs;
	}

}
