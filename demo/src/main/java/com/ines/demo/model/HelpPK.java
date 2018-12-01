package com.ines.demo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the "HELP" database table.
 * 
 */
@Embeddable
public class HelpPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String topic;
	private long seq;

	public HelpPK() {
	}

	public String getTopic() {
		return this.topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}

	public long getSeq() {
		return this.seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HelpPK)) {
			return false;
		}
		HelpPK castOther = (HelpPK)other;
		return 
			this.topic.equals(castOther.topic)
			&& (this.seq == castOther.seq);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.topic.hashCode();
		hash = hash * prime + ((int) (this.seq ^ (this.seq >>> 32)));
		
		return hash;
	}
}