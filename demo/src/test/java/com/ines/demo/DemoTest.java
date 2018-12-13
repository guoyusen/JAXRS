package com.ines.demo;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DemoTest {

	@Deployment
	public static WebArchive createDeployment() {
		System.out.println(DemoApplication.class.getPackage().getName());
		WebArchive archive = ShrinkWrap.create(WebArchive.class)
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource("resources.xml", "resources.xml")
				.addAsResource("test-persistence.xml", "/META-INF/persistence.xml");

		return archive;
	}
	
	@Test
	public void myTest() {
		Assert.assertEquals(1, 1);
	}

}
