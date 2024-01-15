package com.oybek.rest.webservices.restwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonFilter("FilteringBean")
public class FilteringBean {
	private String field1;
//	@JsonIgnore
	private String field2;
	private String field3;


	public FilteringBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}

	@Override
	public String toString() {
		return "FilteringBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}

}
