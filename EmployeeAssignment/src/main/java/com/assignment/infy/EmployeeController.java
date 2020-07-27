package com.assignment.infy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.infy.dao.EmployeeRepo;
import com.assignment.infy.model.Employee;


@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String details()
	{
		return "EntryView";
	}
	
	@RequestMapping("/details")
	public String details(Employee entity)
	{
		repo.save(entity);
		return "EntryView";
	}
	
	@RequestMapping("/getdetails")
	public String getdetails()
	{
		return "ViewEmployees";
	}
	
	
	 @PostMapping("/getdetails")
	 public ModelAndView getdetails(@RequestParam("empId") int empId) 
	 { 
		 ModelAndView mv = new ModelAndView("RetrieveEmployee");
		 Employee employee = repo.findById(empId).orElse(null);
		 mv.addObject(employee);
		 return mv; 
	 }
	 
	 @RequestMapping("/employees")
	 @ResponseBody
	 public String getEmployees()
	 {
		 return repo.findAll().toString();
	 }
	 
	 @RequestMapping("/employees/{empId}")
	 @ResponseBody
	 public String getEmployeesById(@PathVariable("empId") int empId)
	 {
		 
		 return repo.findById(empId).toString();
	 }
	 
	 @PostMapping("/employees")
	 public Employee addCustomer(@RequestBody Employee employee)
	 {
		 repo.save(employee);
		 return employee;
	 }
	 
	 @DeleteMapping("/employees/{empId}")
	 public Employee deleteCustomer(@PathVariable("empId") int empId)
	 {
		 Employee emp = repo.getOne(empId);
		 repo.delete(emp);
		 return emp;
	 }
	 
	 
	 
	 
	 
	 /*
		 * @PostMapping("/getdetails") public String
		 * viewDetails(@RequestParam("empId")int empId,
		 * 
		 * @RequestParam("empName")String empName,@RequestParam("empCity")String
		 * empCity, ModelMap mp) { mp.put("empId", empId); mp.put("empName", empName);
		 * mp.put("empCit", empCity);
		 * 
		 * return "ViewEmployees"; }
		 */
		 
	
	/*
	 * @GetMapping("/entryview") public String entryView() 
	 * { return "EntryView"; }
	 */
	
	
	
	
	/*
	 * @RequestMapping("/") public String entryView() 
	 * { 
	 * 		return "EntryView"; 
	 * }
	 */
	 
	 

}
