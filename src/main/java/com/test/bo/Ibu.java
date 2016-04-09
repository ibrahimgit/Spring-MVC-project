package com.test.bo;

public class Ibu {
	
	private String name;
	private int age;
	private int dob;
	
	public Ibu() {
		
	}
	
	public Ibu(String name, int age, int dob) {
		this.name = name;
		this.age = age;
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
