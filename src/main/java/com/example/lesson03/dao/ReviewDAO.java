package com.example.lesson03.dao;

import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	
	
	public Review selectReview(int id); // 여러 개일 때는 db랑 가까워서 @Param("id") int id <-이런 식으로 다 적어넣어준다.
}
