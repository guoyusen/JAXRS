package com.ines.demo.jbatch.batchlet;

import javax.batch.api.Batchlet;

public class MyBatchlet implements Batchlet{

	@Override
	public String process() throws Exception {
		System.out.println("[Batchlet] process");
		return null;
	}

	@Override
	public void stop() throws Exception {
		System.out.println("[Batchlet] stop");
	}

}
