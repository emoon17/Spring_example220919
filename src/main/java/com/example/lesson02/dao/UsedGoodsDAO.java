package com.example.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.UsedGoods;

@Repository // 저장소에 가깝다.
public interface UsedGoodsDAO { // 인터페이스는 원래 new가 안 되는데 어떻게 뉴가 되는지? = mybatis가 만들어 주는 것.
	
	// input : X (service(bo)가 아무것도 안 줌.)
	
	// output : List<UsedGoods> 
	public List<UsedGoods> selectUsedGoodsList();
	
	
}
