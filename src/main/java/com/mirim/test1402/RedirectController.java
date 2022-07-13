package com.mirim.test1402;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		if (id.equals("tiger")) {

			model.addAttribute("id", id);
//			return "studentOk";
			return "redirect:studentOk"; 
			// 404 오류 발생! => url값에 studentOk를 찍음(controller가 다시 돌아가면서 요청이 새로 들어가면서 studentOk가 RequestMapping에 없으면 404 오류 발생)
		}
		
		model.addAttribute("id", "FAIL!!");
//		return "studentNg";
		return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk() {
		
		return "studentOk";
	}
	
	@RequestMapping("/studentNg")
	public String studentNg() {
		
		return "studentNg";
	}
	
	@RequestMapping("/student1")
	public String student1() {
		
		return "redirect:http://localhost:8888/test1402/test.jsp";	// 직접 접근가능한 주소를 쓸 수 있음
	}
}

// redirect: 는 아예 다른 페이지로 이동할 때 사용
