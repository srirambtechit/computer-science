package com.interview.algorithms.symantec;

public class Employee {
    private String firstName;
    private String lastName;
    private int age;

    public Employee(String firstName, String lastName, int age) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
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

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    @Override
    public boolean equals(Object obj) {

	if (obj == null) {
	    return false;
	}

	if (obj == this) {
	    return true;
	}

	if (getClass() != obj.getClass()) {
	    return false;
	}

	//@formatter:off
	Employee e = (Employee) obj;
	if ((this.firstName.equals(e.firstName) && this.lastName.equals(e.lastName))
		|| (this.firstName.equals(e.lastName) && this.lastName.equals(e.firstName))) {
	    return true;
	}
	//@formatter:on
	return false;
    }

    @Override
    public int hashCode() {
	if (firstName.hashCode() > lastName.hashCode())
	    return (firstName + lastName).hashCode();
	return (lastName + firstName).hashCode();
    }

    @Override
    public String toString() {
	return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
    }

}
