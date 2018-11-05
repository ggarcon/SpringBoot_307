package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model) {

        // First let's create an employee
        Employee employee = new Employee();
        employee.setName("Stephen Bullock");
        employee.setSsn("555-12-1234");

        // Now let's create a Laptop
        Laptop latop = new Laptop();
        Laptop.setBrand("Dell");
        Laptop.setModel("Latitude XL");

        //Add the laptop to the employee
        employee.setLaptop(latop);

        //Save the employee to the database
        employeeRepository.save(employee);

        //Gran all the employee from the database and send them to
        //the template
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }
}