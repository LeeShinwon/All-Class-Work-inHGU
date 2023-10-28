package com.mycompany.my.subjectuser;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.my.board.SubjectService;
import com.mycompany.my.board.SubjectVO;

@Controller
public class SubjectUserController {

	@Autowired
	SubjectUserService userService;
	@Autowired
	SubjectService subjectService;
	

	@RequestMapping(value = "/subjectuser/list", method = RequestMethod.GET)
	public String userlist(Model model, HttpServletRequest request) {
		// model.addAttribute("list", userService.getUserList());

		List<SubjectUserVO> l = new ArrayList<SubjectUserVO>();
		HttpSession session = request.getSession();

		for (SubjectUserVO vo : userService.getUserList()) {

			if (vo.getUserid().equals((session).getAttribute("login"))) {
				l.add(vo);

			}

		}
		model.addAttribute("list", l);

		return "list";
	}
	@RequestMapping(value = "/subjectuser/{semester}", method = RequestMethod.GET)
	public String usersemesterlist(Model model, HttpServletRequest request,@PathVariable("semester") int semester) {
		System.out.println(semester);

		List<SubjectUserVO> l = new ArrayList<SubjectUserVO>();
		HttpSession session = request.getSession();

		for (SubjectUserVO vo : userService.getUserList()) {

			if (vo.getUserid().equals((session).getAttribute("login"))&&vo.getSemester()==semester) {
				l.add(vo);

			}

		}
		request.setAttribute("semester", semester);
		model.addAttribute("list", l);
		

		return "list2";
	}

	@RequestMapping(value = "/subjectuser/add", method = RequestMethod.GET)
	public String addPost(Model model) {
		model.addAttribute("addpostform", subjectService.getSubjectList());

		return "addpostform";
	}

	@RequestMapping(value = "/subjectuser/add/{id}", method = RequestMethod.GET)
	public String addPostform(@PathVariable("id") int id, Model model) {

		SubjectVO subjectVO = subjectService.getSubject(id);
		model.addAttribute("subjectVO", subjectVO);
		return "addpostform2";
	}
	
	@RequestMapping(value = "/subjectuser/addok", method = RequestMethod.POST)
	public String addPostOK(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String userid = request.getSession().getAttribute("login").toString();
		String area1 = request.getParameter("area1");
		String area2 = request.getParameter("area2");
		String area3 = request.getParameter("area3");
		
		String subname = request.getParameter("subname");
		String separ = request.getParameter("separ");
		int credit = Integer.parseInt(request.getParameter("credit"));
		int pro = Integer.parseInt(request.getParameter("pro"));
		int design = Integer.parseInt(request.getParameter("design"));
		int bsm = Integer.parseInt(request.getParameter("bsm"));
		int semester = Integer.parseInt(request.getParameter("semester"));
		
		SubjectUserVO vo = new SubjectUserVO();
		vo.setArea1(area1);
		vo.setArea2(area2);
		vo.setArea3(area3);
		vo.setBsm(bsm);
		vo.setDesign(design);
		vo.setCredit(credit);
		vo.setPro(pro);
		vo.setSepar(separ);
		vo.setSemester(semester);
		vo.setSubname(subname);
		vo.setUserid(userid);
		int i = userService.insertUser(vo);
		if(i==0) {
			System.out.println("데이터 추가 실패 ");
			
		}
		else {
			System.out.println("데이터 추가 성공 ");
		}


		return "redirect:list";
	}
	

	@RequestMapping(value = "/subjectuser/course1", method = RequestMethod.GET)
	public String course(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();

		model.addAttribute("list", (session).getAttribute("login"));

		


		return "list";
	}

	@RequestMapping(value = "/subjectuser/search", method = RequestMethod.GET)
	public String search(Model model, HttpServletRequest request) {
		String area = request.getParameter("area");
		String separ = request.getParameter("separ");
		String subname = request.getParameter("subname");

		List<SubjectVO> l = new ArrayList<SubjectVO>();
		List<SubjectVO> l2 = new ArrayList<SubjectVO>();

		if (area.equals("전체") && separ.equals("전체")) {
			l = subjectService.getSubjectList();

		} else if (!area.equals("전체") && separ.equals("전체")) {
			l = subjectService.getSubjectListS(area);
		} else if (area.equals("전체") && !separ.equals("전체")) {
			for (SubjectVO vo : subjectService.getSubjectList()) {
				if (vo.getSepar().equals(separ))
					l.add(vo);
			}
		} else if (!area.equals("전체") && !separ.equals("전체")) {
			for (SubjectVO vo : subjectService.getSubjectListS(area)) {
				if (vo.getSepar().equals(separ))
					l.add(vo);
			}
		}

		if (!subname.equals("")) {
			for (SubjectVO vo : l) {
				if (vo.getSubname().contains(subname))
					l2.add(vo);
			}
			model.addAttribute("addpostform", l2);
		} else {
			model.addAttribute("addpostform", l);
		}

		return "addpostform";
	}
	@RequestMapping(value = "/subjectuser/editform/{seq}", method = RequestMethod.GET)
	public String editPost(@PathVariable("seq") int seq, Model model) {
		SubjectUserVO subjectVO = userService.getUser(seq);
		model.addAttribute("subjectVO", subjectVO);
		
		return "editform";
	}
	
	@RequestMapping(value = "/subjectuser/editok", method = RequestMethod.POST)
	public String editPostOK(HttpServletRequest request, SubjectUserVO vo) {
		int i = userService.updateUser(vo);
		if(i==0) {
			System.out.println("데이터 수정 실패 ");
			
		}
		else {
			System.out.println("데이터 수정 성공 ");
		}
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/subjectuser/deleteok/{id}", method = RequestMethod.GET)
	public String deletePost(@PathVariable("id") int id) {
		int i = userService.deleteUser(id);
		if(i==0) {
			System.out.println("데이터 삭제  실패 ");
			
		}
		else {
			System.out.println("데이터 삭제 성공 ");
		}
		
		return "redirect:../list";
	}
	
	@RequestMapping(value = "/subjectuser/total", method = RequestMethod.GET)
	public String totalCheck(Model model, HttpServletRequest request) {
		// model.addAttribute("list", userService.getUserList());
		int zero = 0; // 채플
		int one = 0;
		int one_1 = 0; //기독교신앙의 기초1
		int one_2 = 0; //기독교신앙의 기초2
		int one_3 = 0; //세계관1
		int one_4 = 0; //세계관2
		int two = 0;
		int two_1 = 0; // 공동체 리더십 훈련
		int two_2 = 0; // 사회봉사
		int two_3 = 0; // 한동인성교육
		int three = 0;
		int three_1 = 0; // 영어
		int three_2 = 0; // EAP
		int four = 0; // 수학 및 기초과학
		int five = 0; // ICT융합기초
		int six = 0; // 전문 교양
		int major = 0; // 전공
		int major_count = 0; // 전공필수
		int major_design = 0; // 설계
		int culture = 0; // 교양
		int total = 0;

		HttpSession session = request.getSession();
		
		SubjectUserCheckVO co = new SubjectUserCheckVO();
		
		for (SubjectUserVO vo : userService.gettotal()) {

			if (vo.getUserid().equals((session).getAttribute("login"))) {
				
				if(vo.getSubname().contains("채플"))
					zero++;
				else if(vo.getArea3().equals("기독교신앙의 기초1"))
					one_1 += vo.getCredit();
				else if(vo.getArea3().equals("기독교신앙의 기초2"))
					one_2 += vo.getCredit();
				else if(vo.getArea3().equals("세계관1"))
					one_3 += vo.getCredit();
				else if(vo.getArea3().equals("세계관2"))
					one_4 += vo.getCredit();
				
				else if(vo.getSubname().contains("공동체 리더십 훈련"))
					two_1 += vo.getCredit();
				else if(vo.getSubname().contains("사회봉사"))
					two_2 += vo.getCredit();
				else if(vo.getSubname().equals("한동인성교육"))
					two_3 += vo.getCredit();
				
				else if(vo.getArea3().equals("영어1")) {
					if(vo.getSubname().contains("EAP"))
						three_2 += vo.getCredit();
					else
						three_1 += vo.getCredit();
				}
				
				else if (vo.getSeq() == 184 || vo.getSeq() == 189 || vo.getSeq() == 188 || vo.getSeq() == 183)
					five += vo.getCredit();
				
				
				
				else if((vo.getSeq() != 219 && vo.getArea1().equals("전공")) || vo.getSeq() == 187 ) {
					if(vo.getSepar().equals("전공필수"))
						major_count++;
					
					major += vo.getCredit();
					major_design += vo.getDesign();
				}
				
				else
					culture += vo.getCredit();
				
				if(vo.getBsm() != 0)
					four = vo.getBsm();
				
				if(vo.getPro() != 0)
					six += vo.getPro();
				
				one = one_1 + one_2 + one_3 + one_4;
				two = two_1 + two_2 + two_3;
				three = three_1 + three_2;
				culture = culture + one + two + three + four + five + six;
				total = culture + major;
			}
		}
		
		if(zero >= 6) {
			if(one_1 >= 2 && one_2 >= 2 && one_3 >=2 && one_4 >=3) {
				if(two_1 >= 6 && two_2 >= 2 && two_3 >= 1) {
					if(three_2 >= 3) {
						if(four >= 18) {
							if(four >= 18) {
								if(five >= 5) {
									if(major_count >= 11) {
										if(major_design >= 12) {
											if(major >= 60) {
												if(total >= 130) {
													co.setPass("PASS");
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		else
			co.setPass("Fail");
		
		
		co.setZero(zero);
		co.setOne(one);
		co.setOne_1(one_1);
		co.setOne_2(one_2);
		co.setOne_3(one_3);
		co.setOne_4(one_4);
		co.setTwo(two);
		co.setTwo_1(two_1);
		co.setTwo_2(two_2);
		co.setTwo_3(two_3);
		co.setThree(three);
		co.setThree_1(three_1);
		co.setThree_2(three_2);
		co.setFour(four);
		co.setFive(five);
		co.setSix(six);
		co.setMajor(major);
		co.setMajor_count(major_count);
		co.setMajor_design(major_design);
		co.setCulture(culture);
		co.setTotal(total);
		
		System.out.println(total);
		
		model.addAttribute("list", co);

		return "total";
	}

}
