package com.example.demo.employee;


import com.example.demo.address.Address;
import com.example.demo.address.AddressService;
import com.example.demo.agency.Agency;
import com.example.demo.agency.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {


     private EmployeeService employeeService;
     private AgencyService   agencyService;
     private AddressService addressService;

     @Autowired
     public EmployeeController(EmployeeService employeeService, AgencyService agencyService, AddressService addressService) {
         this.employeeService = employeeService;
         this.agencyService = agencyService;
         this.addressService = addressService;
     }

     @GetMapping("/employees")
     public String getAllEmployees(Model model) {
         model.addAttribute("employee",employeeService.getEmployees());
         return "employees";
     }

     @GetMapping("/employees/new")
     public String newEmployeePage(Model model) {
          Employee newEmployee = new Employee();
          List<Agency> listAgencies = agencyService.getAgencies();
          model.addAttribute("employee",newEmployee);
          model.addAttribute("listAgencies",listAgencies);
          return "newEmployee";
     }

    /* POST HTTP Request for put data to database */
    @PostMapping("/employees/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }

    /* DELETE HTTP Request to delete one record of Employee table from database */
    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        Employee deletedEmployee = employeeService.findEmployeeByID(id);
        employeeService.deleteEmployee(deletedEmployee,id);
        return "redirect:/employees";
    }

}
