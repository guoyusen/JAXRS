package com.ines.demo.jbatch.chunk;

import java.io.Serializable;

import javax.batch.api.chunk.ItemReader;

public class MyItemReader implements ItemReader {
	
	private int counter;

	@Override
	public Serializable checkpointInfo() throws Exception {
		System.out.println("[Reader] checkpointInfo");
		return null;
	}

	@Override
	public void close() throws Exception {
		System.out.println("[Reader] close");
	}

	@Override
	public void open(Serializable arg0) throws Exception {
		System.out.println("[Reader] open");
	}

	@Override
	public Object readItem() throws Exception {
		String item;

        if (counter < 22) {
            item = String.format("item-%03d", ++counter);
        } else {
            item = null;
        }

        System.out.println("[Reader] readItem. item = " + item);
		return item;
	}

}
