package com.essam.www.etc;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.WebSocketSession;

import com.essam.www.bean.AdminBean;
import com.essam.www.bean.ClassBean;
import com.essam.www.bean.MemberBean;

@Service
public class EtcMM {
	@Autowired
	private IEtcDao eDao;

	// (EM01)관리자 페이지 이동	
	public ModelAndView goAdmin(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// 세션에서 mbType을 가져옴 --> 관리자 회원(mbType==3)인지 확인하기
		MemberBean loginData = (MemberBean)session.getAttribute("loginData");
		int mbType=loginData.getMbType();
		if(mbType==3){ //관리자라면
			mav.addObject("navtext", "관리자 모드> 통계관리");
			mav.setViewName("etc/admin"); // .jsp
		}else { //관리자가 아니라면 index.jsp로
			mav.setViewName("redirect:/"); // .jsp
		}
		return mav;
	}
	
	// (EM02)통계 가져오기(ajax)
	public Map<String, Object> getStatistic(AdminBean ab) {
		Map<String, Object> statistic = null;
		if(ab.getFilter()=="total") { //필터를 전체로 설정했을 때	
			statistic = eDao.getTotalStatistic(ab);	
		}else if(ab.getFilter()=="new"){ //필터를 신규로 설정했을 때
			statistic = eDao.getNewStatistic(ab);	
		}		
		return statistic;
	}
} 
