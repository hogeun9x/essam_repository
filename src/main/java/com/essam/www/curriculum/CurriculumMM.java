package com.essam.www.curriculum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.essam.www.bean.ClassBean;

@Service
public class CurriculumMM {
	@Autowired
	private ICurriculumDao crDao;
	
	// (CR01+CR02)클래스 커리큘럼 이동 + 커리큘럼 목록 가져오기
	// (CR03+CR04)커리큘럼 상세보기 이동 + 커리큘럼 상세가져오기
	// (CR05+CR06)동영상 페이지 이동 + 동영상 제목, 시작일, 종료일 가져오기	
	// (CR07)커리큘럼 등록 이동	
	// (CR08)커리큘럼 등록하기
	// (CR09)커리큘럼 수정 이동
	// (CR10)커리큘럼 수정하기	

}
