package com.ir.learning.poc.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ir.learning.poc.domainmodel.Department;
import com.ir.learning.poc.domainmodel.Employee;
import com.ir.learning.poc.domainmodel.IStudent;
import com.ir.learning.poc.services.DummyImplService;
import com.ir.learning.poc.services.FooImplService;


@RestController
@RequestMapping("/poc")
public class RestPOCController {
	
	private static final Logger LOGGER = Logger.getLogger(RestPOCController.class);
	
	@Autowired
	private Employee employee;
	
	@Autowired
	private DummyImplService dumyImplService;
	
	@Resource
	private FooImplService fooImplService;
	
	@Autowired
	@Qualifier("student")
	private IStudent student;
	
	@Autowired
	private Department department;
	
	/*public RestPOCController(){
		System.out.println("I am RestPOCControllerrrrroooo");
	}*/
	
	@Value("${recipient}")
	//@Value("Ibrahim")
	private String recipient; 
	
	@RequestMapping(value = "helloworld" , method = RequestMethod.GET)
	public /*@ResponseBody*/ String getHelloWorld() {
		LOGGER.debug("inside getHelloWorld");
		return "Hello " + recipient;
	}
	
	@RequestMapping(value = "session", method = RequestMethod.GET)
	public /*@ResponseBody*/ String getSessionObject(@RequestParam("name") String name) {
		LOGGER.debug("Befor	e setting, Name: " + employee.getName());
		
		LOGGER.debug("dumyImplService: " + dumyImplService);
		LOGGER.debug("department: " + department);
		employee.setName(name);
		LOGGER.debug("After setting, Name: " + employee.getName());
		dumyImplService.foo();
		return employee.getName();
	}
	
	@RequestMapping(value="employee/{empId}", method = RequestMethod.GET, produces="application/json")
	public /*@ResponseBody*/ Department getEmployee(@PathVariable("empId") String id) {
		fooImplService.bar();
		System.out.println(student.getName());
		Department department = new Department();
		department.setName("IR");
		return department;	
	}
	

}
