package com.algorithms.symantec;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  symantec-interview-questions
 * 
 * Given a class Employee
 * 
 * class Employee {
 * int age;
 * String fName;
 * String lName;
 * }
 * 
 * An UI searches for employees using either 'FirstName LastName' or 'LastName FirstName'. 
 * Give a solution that will return the employee details, in O(1) time.
 * e.g. FirstName - John LastName - Walker
 * both John Walker and Walker John should work in O(1). Tried using a hashmap, but search would be O(2).
 * </pre>
 * 
 * @author sriram
 *
 */
public class EfficientSearch {
    private static Map<String, Employee> map = new HashMap<>();

    public static void main(String[] args) {

	Employee e1 = new Employee("sriram", "muthaiah", 26);
	Employee e3 = new Employee("surya", "prakash", 33);

	map.put(e1.getFirstName() + e1.getLastName(), e1);
	map.put(e3.getFirstName() + e3.getLastName(), e3);

	System.out.println(map);
	Employee obj = searchName("sriram muthaiah");
	System.out.println(obj);

	obj = searchName("muthaiah sriram");
	System.out.println(obj);

    }

    static Employee searchName(String name) {
	String firstName = name.substring(0, name.indexOf(" "));
	String lastName = name.substring(name.indexOf(" ") + 1, name.length());

	Employee emp = map.get(firstName + lastName);
	if (emp == null) {
	    emp = map.get(lastName + firstName);
	}
	return emp;
    }
}
