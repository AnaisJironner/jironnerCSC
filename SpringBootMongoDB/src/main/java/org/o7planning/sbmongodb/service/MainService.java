package org.o7planning.sbmongodb.service;

import org.o7planning.sbmongodb.document.Employee;
import org.o7planning.sbmongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MainService {
	
	
	    @Autowired
	    private EmployeeRepository employeeRepository;
	    
	    public Employee save(Employee employee){
	        return employeeRepository.save(employee);
	    }

	   

}
