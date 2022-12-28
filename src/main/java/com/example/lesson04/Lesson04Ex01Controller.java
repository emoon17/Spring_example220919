package com.example.lesson04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.model.User;

@RequestMapping("/lesson04/ex01")
@Controller
public class Lesson04Ex01Controller {

	@Autowired
	private UserBO userBO;
	
	
	// 회원가입 화면
	// http://localhost/lesson04/ex01/add_user_view
	@RequestMapping(path="/add_user_view", method=RequestMethod.GET)  // path는 생략해도 됌
	public String addUserView() {
		//   /WEB-INF/jsp/lesson04/addUSer.jsp
		return "/lesson04/addUser";
	}
	
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String eamil,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// DB insert
		userBO.addUser(name, yyyymmdd, eamil, introduce);
		
		return "lesson04/afterAddUser"; // 결과 jsp
		
	}
	 //http://localhost/lesson04/ex01/get_last_user_view
	@GetMapping("/get_last_user_view")
	public String getLastUserView(Model model) { // view 쪽에 데이터를 보내야 할 때의 파라미터 => view에 보내고 싶은걸 모델에 담으면 된다(바구니로 생각하면 됌)
		
		// db select 가장 마지막 사람 한명 가져올거임.
		User user = userBO.getLastUser();
		// model에 데이터를 담아놓으면 jsp에서 꺼내서 쓸 수 있다.
		model.addAttribute("seller", user); // 앞에는 키 뒤에는 밸류 (map이랑 비슷함)
		model.addAttribute("title", "회원 정보");
		
		return "lesson04/getLastUser"; // 결과 jsp
	}
}