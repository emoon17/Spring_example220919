package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController // 리스판스 바디로 받아 Json으로 내리겠다는 뜻.
public class Lesson03Ex01RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	//http://localhost/less03/ex01?id=2 
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id // 필수 파라미터
			//@RequestParam(value="id") int id // 필수 파라미터
			// value가 필요한 순간 : required 가 false일 때(비필수 일 때)
			//@RequestParam(value="id", required=true) int id // 필수 파라미터 
//			@RequestParam(value="id", required=false) Integer id // 비필수 파라미터
		//	@RequestParam(value="id", defaultValue="1") int id // 비필수 파라미터인데, 디폴값 1 떄문에 null일 수는 없다. (required는 있어도 됌)
	) {
//		if (id == null) {
//			return null;
//		} else {
			return reviewBO.getReview(id);
//		}
	}
}
