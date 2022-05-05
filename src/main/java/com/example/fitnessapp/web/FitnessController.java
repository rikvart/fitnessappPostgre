package com.example.fitnessapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.fitnessapp.model.Data;
import com.example.fitnessapp.model.DataRepository;
import com.example.fitnessapp.model.CategoryRepository;

@Controller
public class FitnessController {

	// Repositories defined below
	@Autowired
	private DataRepository repository;

	@Autowired
	private CategoryRepository crepository;
	
	
	//Method for login
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}    
	
	
	// Show all data
	@RequestMapping("/list")
	public String listData(Model model) {
		model.addAttribute("listofdata", repository.findAll());
		return "datalist";
	}

	//Get all exercises RESTful
	@RequestMapping(value = "/datas", method = RequestMethod.GET)
	public @ResponseBody List<Data> DataListRest() {
		return (List<Data>) repository.findAll();
	}

	// RESTful service to get data by ID
	@RequestMapping(value = "/data/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Data> findDataRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	@RequestMapping("/add")
	public String addData(Model model) {
		model.addAttribute("data", new Data());
		model.addAttribute("categories", crepository.findAll());
		return "adddata";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Data data) {
		repository.save(data);
		return "redirect:list";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteData(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editData(@PathVariable("id") Long id, Model model) {
		model.addAttribute("data", repository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		return "editdata";
	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Data data) {
		repository.save(data);

		return "redirect:/list";
	}

}


