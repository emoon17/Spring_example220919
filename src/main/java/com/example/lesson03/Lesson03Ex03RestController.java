package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex03RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex03?id=23&review=강아지 피자가 있다니 멍!~~
	@RequestMapping("/lesson03/ex03")
	public String ex03 (
			@RequestParam("id") int id,
			@RequestParam("review") String review) {
	
		int row =  reviewBO.updateReviewByID(id, review);
		return "변경 된 행의 개수 : " + row;
		
	}
	
}
