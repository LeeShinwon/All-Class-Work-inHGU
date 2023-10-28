package com.mycompany.my.subjectuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.my.board.SubjectService;
import com.mycompany.my.board.SubjectVO;

@Controller
//@RequestMapping(value="/my")
public class SubjectUserController {
	@Autowired
	SubjectUserService userService;
	@Autowired
	SubjectService subjectService;

	@RequestMapping(value = "/subjectuser/list", method = RequestMethod.GET)
	public String userlist(Model model) {
		model.addAttribute("list", userService.getUserList());
		model.addAttribute("sub", subjectService.getSubjectList());
		return "list";
	}

	@RequestMapping(value = "/subjectuser/add", method = RequestMethod.GET)
	public String addPost() {
		return "addpostform";
	}

	@RequestMapping(value = "/course1", method = RequestMethod.GET)
	public String course1(Model model) {
		model.addAttribute("sub", subjectService.getSubjectList());
		return "course1";
	}
	
	@RequestMapping(value = "/course2", method = RequestMethod.GET)
	public String course2(Model model) {
		return "course2";
	}

	@RequestMapping(value = "/course3", method = RequestMethod.GET)
	public String course3(Model model) {
		return "course3";
	}

	@RequestMapping(value = "/course4", method = RequestMethod.GET)
	public String course4(Model model) {
		return "course4";
	}

	@RequestMapping(value = "/course5", method = RequestMethod.GET)
	public String course5(Model model) {
		return "course5";
	}

	@RequestMapping(value = "/course6", method = RequestMethod.GET)
	public String course6(Model model) {
		return "course6";
	}

	@RequestMapping(value = "/course7", method = RequestMethod.GET)
	public String course7(Model model) {
		return "course7";
	}

	@RequestMapping(value = "/course8", method = RequestMethod.GET)
	public String course8(Model model) {
		return "course8";
	}
	
	@RequestMapping(value = "/course9", method = RequestMethod.GET)
	public String course9(Model model) {
		return "course9";
	}
}
