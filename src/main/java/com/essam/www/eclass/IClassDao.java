package com.essam.www.eclass;

import java.util.List;

import com.essam.www.bean.AttendBean;
import com.essam.www.bean.ClassBean;
import com.essam.www.bean.MemberBean;
import com.essam.www.bean.StudentBean;

public interface IClassDao {
	// class-mapper.xml 사용
	ClassBean getMyClassList(String clsNo);
	
	List<StudentBean> getStudentList(String clsNo);

	MemberBean getStudentInfo(String mbId);

	AttendBean getAttend(String mbId);
}
