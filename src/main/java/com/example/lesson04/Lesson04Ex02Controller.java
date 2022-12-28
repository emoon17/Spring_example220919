package com.example.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.model.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {

	// 학생 추가 화면
	// http://localhost/lesson04/ex02/add_student_view
	@GetMapping("/add_student_view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	@PostMapping("/add_student")
	public String addStudent(
			@ModelAttribute Student student // name(request param)과 필드명이 일치하는 것이 담긴다. 
			) { // @ModelAttribute 객체를 파라미터로 받을 때 생략이 가능하다 (한 객체일 때)
		
		// db insert 
		
		// db select (방금 가입 된 사람)
		
		// view 페이지 응답값
		return "lesson04/afterAddStudent";
		
		
	}
}
