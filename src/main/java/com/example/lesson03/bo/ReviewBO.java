package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(int id) {
		
		return reviewDAO.selectReview(id);
	}
	
	// input : Review 객체
	// output: int(인서트가 성공된 행 수) 
	public int addReview(Review review) { 
		return reviewDAO.insertReview(review);
	}
	
	// input : addReviewAsField(4, "콤비네이션R", "설동이", 5.0, "강아지도 먹어도 돼요!");
	// output: int(인서트가 성공된 행 수) 
	public int addReviewAsField(
			int storeId, String menu, String userName, 
			Double point, String review ) {
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
		
	}
	
	public int updateReviewByID(
			int id, String review) {
		return reviewDAO.updateReviewByID(id, review);
	}

	public void deleteReviewById(int id) {
		reviewDAO.deleteReviewById(id);
	}
}
