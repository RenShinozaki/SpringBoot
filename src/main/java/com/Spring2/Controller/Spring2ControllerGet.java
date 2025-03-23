package com.Spring2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Spring2.Model.table1_Entity;
import com.Spring2.Model.table1_Entity_Primary;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller
public class Spring2ControllerGet {

	@PersistenceContext
	EntityManager entityManager;
	
	// Getメソッドs
	@GetMapping("/")
	public String mm()
	{
		return "StartPage";
	}
	
	// Getメソッド
	@GetMapping("/hello")
	public String hello()
	{
		return "HelloWorld";
	}
	
	// Getメソッド
	@GetMapping("/queryParam")
	public String queryParam(
				@RequestParam(name = "key", required = false, defaultValue = "") String data_key,
				@RequestParam(name = "value", required = false, defaultValue = "") String data_value,
				Model model
	)
	{
		table1_Entity table1_entity = new table1_Entity();
		table1_Entity_Primary table1_entity_primary = new table1_Entity_Primary(data_key, data_value);
		
		table1_entity = entityManager.find(table1_Entity.class, table1_entity_primary);
		
		// data_keyとdata_valueをthymeleafでUI側に引き渡す
		model.addAttribute("data_key", table1_entity.getData_key());
		model.addAttribute("data_value", table1_entity.getData_value());
		
	    return "QueryParam";
	}
}
