package com.essam.www.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.essam.www.bean.MemberBean;

@Controller
public class MemberController {
	@Autowired
	private MemberMM mm;
//	이메일 중복체크(ajax)	
//	로그아웃	

//	수강신청 실행	
//	비밀번호 변경 실행(ajax)	
//	계정관리 이동하기	
//	회원정보 수정 실행	
//	회원정보 가져오기        	
//	교사프로필 이동	
//	교사프로필 가져오기	
//	교사프로필 동록, 수정 이동하기	
//	교사프로필 등록,수정	
//	교사프로필 삭제하기	
//	클래스관리이동	
//	마이클래스이동	
//	내 클래스 목록 가져오기

	// 회원가입 이동
	@RequestMapping(value = "/join")
	String goJoin() {
		return "member/join"; // .jsp
	}

	// 회원가입 실행
	@PostMapping(value = "/memberjoin")
	ModelAndView memberJoin(MemberBean mb, RedirectAttributes rattr) {
		// System.out.println(mb.getMbId());
		// System.out.println(mb.getMbPwd());
		// System.out.println(mb.getMbBirth());
		ModelAndView mav = mm.memberJoin(mb, rattr);
		return mav;
	}

	// 로그인 이동
	@RequestMapping(value = "/login")
	String goLogin() {
		return "member/login"; // .jsp
	}

	// 로그인 실행
	@PostMapping(value = "/access")
	ModelAndView access(MemberBean mb,HttpServletRequest request, RedirectAttributes rattr) {
		return mm.access(mb, request, rattr);
	}
}
