package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Service.EmployeService;
import com.example.demo.domain.Employee;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {
	@Autowired
	private EmployeService employeservice;
	@GetMapping("/addemployee")
	public String viewhomepage(Model model) {
		model.addAttribute("employee",new Employee());
		return "addemployee";
	}
	@PostMapping("/save")
	public String savedetails(@ModelAttribute("employee") Employee employee) {
		employeservice.saveemployedetails(employee);
		return "redirect:/Employee";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView editpage(@PathVariable("id") Long id) {
		ModelAndView model=new ModelAndView("addemployee");
		Employee employee=employeservice.getOne(id);
		model.addObject("employee", employee);
		return model;
	}
	@RequestMapping("/delete/{id}")
	public String Deleteemploye(@PathVariable("id") Long id) {
		employeservice.deleteemployeedetails(id);
		return "redirect:/Employee";
	}
}
