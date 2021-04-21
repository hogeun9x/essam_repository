package com.essam.www.eclass;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.essam.www.bean.ClassBean;
import com.essam.www.bean.MemberBean;
import com.essam.www.bean.StudentBean;
import com.essam.www.file.FileMM;

@Service
public class ClassMM {
	@Autowired
	private FileMM fm;
	
	@Autowired
	private IClassDao cDao;	
	// (CM01)공지사항 쓰기, 수정페이지 이동	
	// (CM02)클래스 소개 이동(관계자용)	
	// (CM03+CM04)과제 목록 페이지 이동 + 과제 목록 가져오기		
	// (CM05+CM06)과제 상세 페이지 이동 + 과제 상세 가져오기
	// (CM07)댓글 목록 가져오기(ajax)	
	// (CM08)댓글 등록(ajax)	
	// (CM09)댓글 수정(ajax)	
	// (CM10)댓글 삭제(ajax)		
	// (CM11)과제 수정,등록	
	// (CM12)과제 삭제
	// (CM11)공지사항 수정, 등록	
	// (CM12)공지사항 삭제
	// (CM19+CM04)공지사항 목록 페이지 이동 + 공지사항 목록 가져오기	
	// (CM20+CM06)공지사항 상세 페이지 이동 + 공지사항 상세 가져오기	
	
	
	// (CM13+CM14)출석 현황 이동 + 출석현황 가져오기
	public ModelAndView goAttend(String mbId) {
		ModelAndView mav = new ModelAndView();
		StudentBean attendInfo = new StudentBean();
		attendInfo = cDao.getAttend(mbId);
		// 가져온 정보를 mav에 넣기
		mav.addObject("attendInfo",attendInfo);	
		//class_attend.jsp로 이동하기 위해 viewname 지정
		mav.setViewName("class/class_attend"); // .jsp
		return mav;
	}
	
	
		
		
	// (CM15+CM16)학생목록 이동 + 학생목록 가져오기
	public ModelAndView goStudentList(String clsNo) {
		ModelAndView mav = new ModelAndView();
		List<StudentBean> sList = null;
		sList = cDao.getStudentList(clsNo);
		// 가져온 정보를 mav에 넣기
		mav.addObject("sList",sList);	
		// class_studentinfo.jsp로 이동하기 위해 viewname 지정
		mav.setViewName("class/class_studentinfo"); // .jsp
		return mav;
	}
		
	// (CM17+CM18)학생정보보기 이동 + 학생정보 가져오기
	public ModelAndView goStudentInfo(String mbId) {
		ModelAndView mav = new ModelAndView();
		MemberBean mInfo = new MemberBean();
		mInfo = cDao.getStudentInfo(mbId);
		// 가져온 정보를 mav에 넣기
		mav.addObject("mInfo",mInfo);	
		// class_studentinfo_read.jsp로 이동하기 위해 viewname 지정
		mav.setViewName("class/class_studentinfo_read"); // .jsp
		return mav;
	}
		
	// (CM21)클래스 등록, 수정하기 페이지 이동
	public ModelAndView goClassInfoWrite(String clsNo) {
		ModelAndView mav = new ModelAndView();
		ClassBean clsInfo = new ClassBean();
		if(clsNo!=null) {
			clsInfo = cDao.getMyClassList(clsNo);
			mav.addObject("clsInfo",clsInfo);
		}
		mav.setViewName("class/class_write"); // .jsp
		return mav;
	}
	
	// (CM22)클래스 등록, 수정하기
	/*  
	class_write.jsp에서 입력한 클래스 정보를 MultipartRequest와 ClassBean 형태로
	ClassController의 /class/classinfo/update -->ClassMM의 classClassinfoUpdate()에 전달		*/
	public ModelAndView classClassinfoUpdate(MultipartHttpServletRequest newInfo, ClassBean cb) {
		ModelAndView mav = new ModelAndView();
		boolean updatedOrNot = true;	
		/*
		클래스이미지를 가져왔다면 saveFile()에 MultipartFile 전달, fileNo 반환받음							
		clsNo가 null이 아니라면 기존 클래스 정보의 fileNo를 가져옴							
		*/
		
		
		// clsNo가 null이라면 insert, 아니라면 update 실행(Dao)												
		if(cb.getClsNo()!=null){//clsNo가 있다면 --> 수정(UPDATE) SQL문 실행
			//updatedOrNot = cDao.classClassinfoUpdate();
		}else {//clsNo가 있다면 --> 삽입(INSERT) SQL문 실행
			//updatedOrNot = cDao.classClassinfoInsert();
		}
		
		
		/*
		기존의 fileNo를 가져왔다면 deleteFile에 넘겨 이미지파일 삭제							
		성공시 classinfo_t.jsp로 이동(/class/classinfo)
		*/
		if(updatedOrNot) { //등록(수정) 성공시
			mav.setViewName("class/classinfo_t"); //.jsp
		}else { //등록(수정) 실패시
			mav.setViewName("class/class_wirte"); //.jsp
		}
		return mav;
	}
}
