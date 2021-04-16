package com.essam.www.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.essam.www.bean.MemberBean;

@Service
public class MemberMM {
	@Autowired
	private IMemberDao mDao;
//	로그인	
//	회원가입	
//	이메일 중복체크(ajax)	
//	로그아웃	
//	로그인 실행	
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

	// 회원가입 실행
	public ModelAndView memberJoin(MemberBean mb, RedirectAttributes rattr) {
		ModelAndView mav = new ModelAndView();
		// 비밀번호 암호화 라이브러리 불러오기
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// 비밀번호 암호화
		String encPwd = encoder.encode(mb.getMbPwd());
		mb.setMbPwd(encPwd);

		if (mDao.memberJoin(mb)) { // 회원등록 성공시
			rattr.addFlashAttribute("fMsg", "회원가입 성공");
			mav.setViewName("redirect:/");
		} else {
			rattr.addFlashAttribute("fMsg", "회원가입 실패");
			mav.setViewName("redirect:/join");
		}
		// 관심카테고리도 등록하는 경우 dao 작업 추가
		return mav;
	}

	// 로그인 실행
	public ModelAndView access(MemberBean mb, HttpServletRequest request, RedirectAttributes rattr) {
		ModelAndView mav = new ModelAndView();
		MemberBean mbInfo = mDao.getMemberInfo(mb.getMbId());
		if (mbInfo != null) { // 아이디 정보가 존재할 경우
			// 암호화 라이브러리 가져오기
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(mb.getMbPwd(), mbInfo.getMbPwd())) {
				// 비밀번호가 일치 한다면
				MemberBean loginData = new MemberBean();
				loginData.setMbId(mbInfo.getMbId());
				loginData.setMbType(mbInfo.getMbType());
				loginData.setMbName(mbInfo.getMbName());
				loginData.setMbNickName(mbInfo.getMbNickName());
				request.getSession().setAttribute("loginData", loginData);
				mav.setViewName("redirect:/"); // 메인으로
				rattr.addFlashAttribute("fMsg","로그인 성공");
			}else { // 비밀번호 불일치시
				mav.setViewName("redirect:/login"); // 로그인 페이지로
				rattr.addFlashAttribute("fMsg","로그인 실패");
			}
		}else { // 아이디가 없는 경우
			mav.setViewName("redirect:/login"); // 로그인 페이지로
			rattr.addFlashAttribute("fMsg","로그인 실패");
		}
		return mav;
	}
}
