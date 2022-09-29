package com.kb.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kb.util.HibernateUtil;

public class AggregateFunctions {
	public static void main(String[] args) {
		// Get session factory using Hibernate Util class
		SessionFactory sf = HibernateUtil.getSessionFactory();
		// Get session from Sesson factory
		Session session = sf.openSession();

		// Retrieve Max salary of Employee
		Query maxSalaryQuery = session.createQuery("SELECT MAX(salary) FROM Employee");
		Object maxSalary = maxSalaryQuery.getSingleResult();
		System.out.println("Maximum salary of Employee -> " + maxSalary);

		// Retrieve Min salary of Employee
		Query minSalaryQuery = session.createQuery("SELECT MIN(salary) FROM Employee");
		Object minSalary = minSalaryQuery.getSingleResult();
		System.out.println("Minimum salary of Employee -> " + minSalary);

		// Retrieve Average salary of Employee
		Query avgSalaryQuery = session.createQuery("SELECT AVG(salary) FROM Employee");
		Object avgSalary = avgSalaryQuery.getSingleResult();
		System.out.println("Average salary of Employees -> " + avgSalary);

		// Retrieve Number of Employees
		Query empCountQuery = session.createQuery("SELECT COUNT(*) FROM Employee");
		Object empCount = empCountQuery.getSingleResult();
		System.out.println("Total number of Employees -> " + empCount);

		// Retrieve Min salary of Employee
		Query sumSalaryQuery = session.createQuery("SELECT SUM(salary) FROM Employee");
		Object sumSalary = sumSalaryQuery.getSingleResult();
		System.out.println("Total sum of salary of all Employees -> " + sumSalary);

		session.close();
	}

}
