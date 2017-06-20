package com.javamultiplex;

import java.util.List;

public class Student {

	private int rollNumber;

	private String name;

	private int age;

	private String address;

	private List<String> subjects;

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [roll number = " + getRollNumber() + ", name = " + getName() + ", age = " + getAge()
				+ ", address = " + getAddress() + ", subjects = " + getSubjects() + "]";
	}

}
