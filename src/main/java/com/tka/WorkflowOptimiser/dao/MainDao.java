package com.tka.WorkflowOptimiser.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.WorkflowOptimiser.entity.Country;

import com.tka.WorkflowOptimiser.entity.Employees;

@Repository
public class MainDao {

	@Autowired 
	SessionFactory factory;
	public String addCountry(Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		msg = "Country Added Successfully";
		try {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.persist(c);
		tx.commit();
		}catch(Exception e){
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		 
		return msg;
	}
	public String updateCountry(Country c, int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		msg = "Country Udated...";
		try {
		session = factory.openSession();
		tx = session.beginTransaction();
		session.persist(c);
		tx.commit();
		}catch(Exception e){
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		 
		return msg;
	}
	public String deleteCountry(int cid) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
		session = factory.openSession();
		tx = session.beginTransaction();
		Country country = session.get(Country.class, cid);
		session.remove(country);
		tx.commit();
		
		msg = "Country Deleted...";
		
		}catch(Exception e){
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!= null) {
				session.close();
			}
		}
		 
		return msg;	
		}
	public List<Country> getAllCountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> list = null;
		
		try {
		session = factory.openSession();
		tx = session.beginTransaction();
		String hqlQuery = "from Country";
		
		Query<Country> query = session.createQuery(hqlQuery,Country.class);
		list = query.list();
		tx.commit();
		
		}catch(Exception e){
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!= null) {
				session.close();
			}
		}
		 
		return list;
			}
	public Country getParticularRecordbyId(int cid) {
		Session session = null;
		Transaction tx = null;
		Country country = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			country = session.get(Country.class,cid);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return country;
	}
	public String addEmployee(Employees emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
		
		session.persist(emp);
		tx.commit();
		msg = "Employee Added Successfull....";
		}catch(Exception e){
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}
	public String updateEmp(Employees e, int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		msg = "Employee Udated...";
		try {
		session = factory.openSession();
		tx = session.beginTransaction();
		Employees emp = session.get(Employees.class, id);
		emp.setName(emp.getName());
		emp.setCountry(emp.getCountry());
		emp.setStatus(emp.getStatus());
		}catch(Exception ex){
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		 
		return msg;
		
	}
	public String deleteEmp(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
		session = factory.openSession();
		tx = session.beginTransaction();
		Employees employee = session.get(Employees.class, id);
		session.remove(employee);
		tx.commit();
		
		msg = "Employee Deleted...";
		
		}catch(Exception e){
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!= null) {
				session.close();
			}
		}
		 
		return msg;
		
	}
	public List<Employees> getAllRecord() {
		Session session = null;
		Transaction tx = null;
		List<Employees> list = null;
		
		try {
		session = factory.openSession();
		tx = session.beginTransaction();
		String hqlQuery = "from Employees";
		
		Query<Employees> query = session.createQuery(hqlQuery,Employees.class);
		list = query.list();
		tx.commit();
		
		}catch(Exception e){
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!= null) {
				session.close();
			}
		}
		 
		return list;
	}
	public Employees login(Employees e) {
		Session session = null;
		Transaction tx = null;
		Employees emp = null;
		
		try {
			session = factory.openSession();
			tx= session.beginTransaction();
			String hqlQuery = "from Employees where emailid=:emailid and mobileno=:mobileno";
			
			Query<Employees> query = session.createQuery(hqlQuery,Employees.class);
			query.setParameter("emailid", e.getEmailid());
			query.setParameter("mobileno", e.getMobileno());
			
			emp = query.uniqueResult();
			tx.commit();
		}catch(Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return emp;
	}
	
	public List<Employees> salaryRange(double startSalary, double endSalary) {
		Session session = null;
		Transaction tx = null;
		List<Employees> list = null;
		
		try {
		session = factory.openSession();
		tx = session.beginTransaction();
		String hqlQuery = "from Employees where salary between :startsal and :endsal";
		
		Query<Employees> query = session.createQuery(hqlQuery,Employees.class);
		query.setParameter("startsal", startSalary);
		query.setParameter("endsal", endSalary);
		list = query.list();
		tx.commit();
		
		}catch(Exception e){
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!= null) {
				session.close();
			}
		}
		return list;
	}
	public List<Employees> statusCheck(String status) {
		Session session = null;
		Transaction tx = null;
		List<Employees> list = null;
		
		try {
		session = factory.openSession();
		tx = session.beginTransaction();
		String hqlQuery = "from Employees where status=:mystatus";
		
		Query<Employees> query = session.createQuery(hqlQuery,Employees.class);
		query.setParameter("mystatus", status);
		list = query.list();
		tx.commit();
		
		}catch(Exception e){
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!= null) {
				session.close();
			}
		}
		return list;
	}
	public String particularStatus(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
		session = factory.openSession();
		tx = session.beginTransaction();
		Employees employee = session.get(Employees.class, id);
		if(Objects.isNull(employee)) {
			msg = "Record is nor found";
		}else {
			if(employee.getStatus().equalsIgnoreCase("suspended")) {
				msg = "Ststus is not updated due to suspend";
			}else {
				if(employee.getStatus().equalsIgnoreCase(employee.getStatus()))?"inactive":"active";
				employee.setStatus(status);
				session.merge(employee);
				msg = "status is updated";
			}
		}
		tx.commit();
	}catch(Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}finally {
		
		if(session!= null) {
			session.close();
		}
	}
		return msg;
	}	
}