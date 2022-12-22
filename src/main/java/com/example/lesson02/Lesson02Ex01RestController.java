package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.model.UsedGoods;

@RestController
public class Lesson02Ex01RestController { //ResponseBody로 데이터를 내릴거다.
	
	@Autowired
	private UsedGoodsBO usedGoodsBO; // 스프링 빈을 DI(주입) 받음
	
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() { //리케스트 맵핑으로 들어가서 usedGoods라는 리스트로 리턴 되는 값을 레스트컨트롤러 안에 있는 리스판ㄴ스바디에 담아서 응답을 내려준다
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		return usedGoodsList;//json이 된다.  
	}

}
