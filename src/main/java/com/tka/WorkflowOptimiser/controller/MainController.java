package com.tka.WorkflowOptimiser.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tka.WorkflowOptimiser.entity.Country;
import com.tka.WorkflowOptimiser.entity.Employees;
import com.tka.WorkflowOptimiser.service.MainService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class MainController {
	
	@Autowired
	MainService service;
	@PostMapping("addCountry")
	public String addCountry(@RequestBody Country c) {
		String msg =  service.addCountry(c);
		return msg;
	}
	
	@PutMapping("UpdateCountry/{id}")
	public String updateCountry(@RequestBody Country c, @PathVariable int id) {
		String msg = service.updateCountry(c,id);
		return msg;
	}
	
	@DeleteMapping("deleteCountry/{cid}")
	public String deleteCountry(@PathVariable int cid) {
	String msg = service.deleteCountry(cid);
	return msg;
	}
	
	@GetMapping("allRecord")
	public List<Country> getAllCountry(){
		List<Country> list = service.getAllCountry();
		return list;
	}
	
	@GetMapping("particularRecord/{cid}")
	public Country getParticularRecordbyId(@PathVariable int cid) {
		Country country = service.getParticularRecordbyId(cid);
		return country;
	} 
	
	@PostMapping("addemp")
	public String addEmployee(@RequestBody Employees emp) {
		String str = service.addEmployee(emp);
		return str;
	}
	
	@PutMapping("updateEmp/{id}")
	public String updateEmp(@RequestBody Employees e, @PathVariable int id) {
		String msg = service.updateEmp(e,id);
		return msg;
		
	}
	
	@DeleteMapping("deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id) {
		String msg = service.deleteEmp(id);
		return msg;
	}
	
	@GetMapping("getAllRecord")
	public List<Employees> getAllRecord(){
		List<Employees> list = service.getAllRecord();
		return list;
	}
	
	@PostMapping("login")
	public HashMap login(@RequestBody Employees e) {
		HashMap map = service.login(e);
		return map;
	}
	
	@GetMapping("salaryRange/{startSalary}/{endSalary}")
	public List<Employees> salaryRange(@PathVariable double startSalary, @PathVariable double endSalary){
		List<Employees> list = service.salaryRange(startSalary,endSalary);
		return list;
	}
	
	@GetMapping("statusCheck/{status}")
	public List<Employees> statusCheck(@PathVariable String status){
		List<Employees> list = service.statusCheck(status);
		return list;
	}
	
	@GetMapping("particularStatus/{id}")
	public String particularStatus(@PathVariable int id) {
		String msg = service.particularStatus(id);
		return msg;
		
	}
}
