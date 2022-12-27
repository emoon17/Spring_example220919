package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	
	
	public Review selectReview(int id); // 여러 개일 때는 db랑 가까워서 @Param("id") int id <-이런 식으로 다 적어넣어준다.
	
	public int insertReview(Review review);
	
	public int insertReviewAsField(
			// 하나의 맵으로 구성 됌 (@Param)
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review );
	
	public int updateReviewByID(
			@Param("id") int id, 
			@Param("review") String review);
	
	public int deleteReviewById(int id);
}
