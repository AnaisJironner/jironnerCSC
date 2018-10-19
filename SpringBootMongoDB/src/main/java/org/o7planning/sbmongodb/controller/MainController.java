package org.o7planning.sbmongodb.controller;
 
import java.util.Date;
import java.util.List;
 
import org.o7planning.sbmongodb.document.Employee;
import org.o7planning.sbmongodb.repository.EmployeeRepository;
import org.o7planning.sbmongodb.repository.EmployeeRepositoryCustom;
import org.o7planning.sbmongodb.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
 
    private static final String[] NAMES = { "Tom", "Jerry", "Donald" };
 
    @Autowired
    MainService employeeService;
    
    @Autowired
    private EmployeeRepositoryCustom employeeRepositoryCustom;
 
    @Autowired
    private EmployeeRepository employeeRepository;
 
    @ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/testInsert'>Test Insert</a></li>";
        html += "</ul>";
        return html;
    }
 
    @ResponseBody
    @RequestMapping("/testInsert")
    public String testInsert() {
        Employee employee = new Employee();
 
        long id = this.employeeRepositoryCustom.getMaxEmpId() + 1;
        int idx = (int) (id % NAMES.length);
        String fullName = NAMES[idx] + " " + id;
 
        employee.setId(id);
        employee.setEmpNo("E" + id);
        employee.setFullName(fullName);
        employee.setHireDate(new Date());
        this.employeeRepository.insert(employee);
        
        employeeService.save(employee);
        return "Inserted: " + employee;
    }
 
   
 
}