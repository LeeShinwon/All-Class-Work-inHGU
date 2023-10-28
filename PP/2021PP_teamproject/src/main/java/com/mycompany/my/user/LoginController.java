package com.mycompany.my.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.my.subjectuser.SubjectUserController;


@Controller
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	UserServiceimpl service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
	public String loginCheck(HttpSession session, UserVO vo) {
			
			
		String returnURL ="";
		if(session.getAttribute("login")!=null) {
			session.removeAttribute("login");
		}
		
		UserVO loginvo = service.getUser(vo);
		
		if(loginvo != null) {
			System.out.println("로그인 성공! ");
			session.setAttribute("login", loginvo.getUserid());
	
			returnURL = "redirect:/subjectuser/list";
		}
		else {
			System.out.println("로그인 실패! ");
			returnURL = "redirect:/login/login";
		}
		return returnURL;
	}
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/login";
	}
	
}
