package com.ines.demo.jbatch.chunk;

import java.io.Serializable;
import java.util.List;

import javax.batch.api.chunk.ItemWriter;

public class MyItemWriter implements ItemWriter {

	@Override
	public Serializable checkpointInfo() throws Exception {
		System.out.println("[Writer] checkpointInfo");
		return null;
	}

	@Override
	public void close() throws Exception {
		System.out.println("[Writer] close");
	}

	@Override
	public void open(Serializable arg0) throws Exception {
		System.out.println("[Writer] open");
	}

	@Override
	public void writeItems(List<Object> items) throws Exception {
		System.out.println("[Writer] writeItems. items = " + items);
	}

}
