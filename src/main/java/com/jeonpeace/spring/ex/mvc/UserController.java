package com.jeonpeace.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeonpeace.spring.ex.mvc.domain.User;
import com.jeonpeace.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/mvc/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping(path="/mvc/user/info", method=RequestMethod.GET)
	@GetMapping("/info")
	public String userInfo(Model model) {
		
		User user = userService.getLastUser();
		
		model.addAttribute("result", user);
		model.addAttribute("title", "회원정보");
		
		return "mvc/userinfo";
		
	}
	
	@PostMapping("/create")
	public String createdUser(@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce
			, Model model) {
		
		User user = new User();
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce);
		
		userService.addUserByObject(user);
		
		model.addAttribute("result", user);
		
		return "mvc/userinfo";
		
//		return "redirect:/mvc/user/info";
	
	}
	
	@GetMapping("/input")
	public String userINput() {
		return "mvc/userInput";
	}
	
}
