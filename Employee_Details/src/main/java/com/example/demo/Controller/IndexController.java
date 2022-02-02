package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.EmployeService;
import com.example.demo.domain.Employee;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private EmployeService employeservice;
	@RequestMapping("/Employee")
	public String viewhome(Model model) {
		List<Employee> allemployee=employeservice.allemployee();
		model.addAttribute("allemployee",allemployee);
		return "employe";
	}
	@RequestMapping("/")
	public String save() {
		return "employe";
	}
}
