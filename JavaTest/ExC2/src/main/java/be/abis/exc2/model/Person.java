package be.abis.exc2.model;

import be.abis.exc2.exception.PersonShouldBeAdultException;
import be.abis.exc2.exception.SalaryTooLowException;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	
	private int personNumber;
	private String firstName;
	private String lastName;
	private LocalDate birthDay;
	private Company company;
	private double grossSalary;

	public Person(){

	}

	public Person(int personNumber, String firstName, String lastName, LocalDate birthDay) {
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
	}

	public Person(int personNumber, String firstName, String lastName, LocalDate birthDay, Company company) {
		this(personNumber,firstName,lastName,birthDay);
		this.company = company;
	}

	public Person(int personNumber, String firstName, String lastName, LocalDate birthDay, double grossSalary) {
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.grossSalary = grossSalary;
	}

	public Person(int personNumber, String firstName, String lastName, LocalDate birthDay, Company company, double grossSalary) {
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.company = company;
		this.grossSalary = grossSalary;
	}

	public int getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	@Override
	public String toString() {
		String text = null;
		try {
			text = "Person " + this.personNumber + ": " + this.firstName + " " +this.lastName + " (" +this.calculateAge()+ " years old)";
		} catch (PersonShouldBeAdultException e) {
			e.printStackTrace();
		}
		if (this.company != null) {
			text+= " works for " + this.company.getName() + " in " + this.company.getAddress().getTown() + ".";
		} else {
			text+= " is not employed for the moment.";
		}
		return text;
	}
	
	
	public int calculateAge() throws PersonShouldBeAdultException {
		int age=0;
		age = Period.between(birthDay, LocalDate.now()).getYears();
		if(age < 18){
			throw new PersonShouldBeAdultException();
		}
		return age;
	}

	public double calculateNetSalary() throws SalaryTooLowException {
		double netSalary=0;
		netSalary =  grossSalary * ((100-company.calculateTaxToPay()) / 100);
		if(netSalary<1500){
			throw new SalaryTooLowException();
		}
		return netSalary;
	}
	


}
