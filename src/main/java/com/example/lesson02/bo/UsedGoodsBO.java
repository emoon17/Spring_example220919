package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service // 여기에 로직이 들어있겠구나.하고 알게 해주는것.
public class UsedGoodsBO { // bo: bussiness object
	
	@Autowired // Spring bean을 주입 받음(Dependency Injection)
	private UsedGoodsDAO usedGoodsDAO;
	// input : X (컨트롤러가 아무것도 안 줌.)
	
	// output : List<UsedGoods> 
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsDAO.selectUsedGoodsList();
	}
	

}
