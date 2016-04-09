package com.ir.learning.poc.domainmodel;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;


@Repository
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Employee/* implements Serializable*/ {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	private String name;

	public String getName() {
		//throw new NullPointerException();
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
