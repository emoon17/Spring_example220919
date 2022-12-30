package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05ExController {
	
	//http://localhost/lesson05/ex01
	@GetMapping("/ex01")
	public String ex01() {
		return "/lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String x02(Model model) { 
		// List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("망고");
		fruits.add("딸기");
		fruits.add("귤");
		fruits.add("포도");
		fruits.add("복숭아");
		// model에 담기
		model.addAttribute("fruits", fruits);
		
		// List<map>
		List<Map<String, Object>> users = new ArrayList<>();	
		Map<String, Object> user = new HashMap<>();
		user.put("name", "설동");
		user.put("age", 3);
		user.put("hobby", "산책");
		users.add(user);
		
		user = new HashMap<>();
		user.put("name", "두두");
		user.put("age", 29);
		user.put("hobby", "애니");
		users.add(user);
		
		// model에 담기
		model.addAttribute("users", users);
		
		return "/lesson05/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03() {
		return "lesson05/ex03";
	}
}
