package com.Spring2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Spring2.Factory.Entity_SessionFactory;
import com.Spring2.Model.table1_Entity;
import com.Spring2.Model.table1_Entity_Primary;

import jakarta.persistence.EntityManager;

@Controller
public class Spring2Controller {
	
	// table1のエンティティクラス
//	@Autowired
//	table1_Entity table1_entity;
	
	// table1のエンティティクラスの主キー
//	@Autowired
//	table1_Entity_Primary table1_entity_primary;

//	@Autowired
//	EntityManager entityManager;
	
	// Getメソッド
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
		
		// 検索キーを設定
//		table1_entity_primary.setData_key(data_key);
//		table1_entity_primary.setData_value(data_value);
		
		System.out.println("****************here1*********************");
		
		EntityManager wEntityManager = Entity_SessionFactory.getSessionFactory().createEntityManager();
		
		System.out.println("****************here2*********************");
		
		// 主キーで検索
		wEntityManager.getTransaction().begin();
		
		System.out.println("****************here3*********************");

		System.out.println("Class Loader for table1_Entity_Primary: " + table1_entity_primary.getClass().getClassLoader());
		System.out.println("Class Loader for table1_Entity: " + table1_Entity.class.getClassLoader());

		
		table1_entity = wEntityManager.find(table1_Entity.class, table1_entity_primary);
//		table1_entity = Entity_SessionFactory.getSessionFactory().createEntityManager().find(table1_Entity.class, table1_entity_primary);
		
		System.out.println("****************here4*********************");
		
		wEntityManager.getTransaction().commit();
		
		System.out.println("****************here5*********************");
		
		// data_keyとdata_valueをthymeleafでUI側に引き渡す
		model.addAttribute("data_key", table1_entity.getData_key());
		model.addAttribute("data_value", table1_entity.getData_value());
		
		System.out.println("****************here6*********************");
		
	    return "QueryParam";
	}
}
