package oodemo;

import java.util.List;

public class Company {
	
	private String companyName;
	private List<Person> personList;
	
	public Company() {}
	
	public Company(String companyName, List<Person> personList) {
		this.companyName = companyName;
		this.personList = personList;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public List<Person> getPersonList() {
		return personList;
	}

}
