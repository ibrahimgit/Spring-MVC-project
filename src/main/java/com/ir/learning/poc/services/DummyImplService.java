package com.ir.learning.poc.services;

import org.springframework.stereotype.Service;


@Service
public class DummyImplService {
	
	public void foo(){
		//throw new RuntimeException();
		System.out.println("I am in DummyImplService");
	}

}
