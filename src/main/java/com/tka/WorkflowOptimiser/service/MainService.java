package com.tka.WorkflowOptimiser.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.WorkflowOptimiser.dao.MainDao;
import com.tka.WorkflowOptimiser.entity.Country;
import com.tka.WorkflowOptimiser.entity.Employees;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	public String addCountry(Country c) {
		// TODO Auto-generated method stub
		
		String msg = dao.addCountry(c);
		if(Objects.isNull(msg)) {
			msg = "Country is not added";
		}
		return msg;
	}
	public String updateCountry(Country c, int id) {
		// TODO Auto-generated method stub
		String msg = dao.updateCountry(c,id);
		if(Objects.isNull(msg)) {
			msg = "Country is not updated";
		}
		return msg;
		
	}
	public String deleteCountry(int cid) {
		String msg = dao.deleteCountry(cid);
		if(Objects.isNull(msg)) {
			msg = "Country is  deleted";
		}
		return msg;
	}
	public List<Country> getAllCountry() {
		List<Country> list = dao.getAllCountry();
		return list;
	}
	public Country getParticularRecordbyId(int cid) {
		Country country = dao.getParticularRecordbyId(cid);
		if(Objects.isNull(country)) {
			country = null;
		}
		return country;
	}
	public String addEmployee(Employees emp) {
		String str = dao.addEmployee(emp);
		if(Objects.isNull(emp)) {
			emp = null;
		}
		return str;
	}
	public String updateEmp(Employees e, int id) {
	String msg	= dao.updateEmp(e,id);
	if(Objects.isNull(msg)) {
		msg = "Employee is not updated.....";
	}
	return msg;
	}
	public String deleteEmp(int id) {
		String msg = dao.deleteEmp(id);
		if(Objects.isNull(msg)) {
			msg = "Employee is not Deleted.....";
		}
		return msg;
	}
	public List<Employees> getAllRecord() {
		List<Employees> list = dao.getAllRecord();
		return list;
	}
	public HashMap login(Employees e) {
		Employees emp = dao.login(e);
		
		HashMap map = new HashMap();
		if(Objects.isNull(emp)) {
			map.put("msg", "Invalid User");
		}else {
			map.put("msg", "Valid User");
		}
		map.put("user", emp);
		return map;
	}
	
	public List<Employees> salaryRange(double startSalary, double endSalary) {
		List<Employees> list = dao.salaryRange(startSalary, endSalary);
		return list;
	}
	public List<Employees> statusCheck(String status) {
		List<Employees> list = dao.statusCheck(status);
		return list;
	}
	public String particularStatus(int id) {
		String msg = dao.particularStatus(id);
		return msg;
	}
}
