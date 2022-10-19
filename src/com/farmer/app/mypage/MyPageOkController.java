package com.farmer.app.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.member.vo.MemberVO;
import com.farmer.app.mypage.dao.MypageDAO;

public class MyPageOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MypageDAO mypageDAO = new MypageDAO();
		MemberVO memberVO = new MemberVO();
		Result result = new Result();
		
//		System.out.println(mypageDAO.selectMyPage(2));
		memberVO = mypageDAO.selectMyPage(2);
		
		String memberName = memberVO.getMemberName();
		String memberLocation = memberVO.getMemberLocation();
		int memberGrade = memberVO.getMemberGrade();
		String memberType;
		String mentorType;
		
//		가입 형태 검사
		if(memberGrade < 0) {
			memberType = "농장주";
			req.setAttribute("memberType", memberType);
		}else if(memberGrade == 0) {
			memberType = "관리자";
			req.setAttribute("memberType", memberType);
		}else if(memberGrade == 1) {
			memberType = "일반 사용자";
			req.setAttribute("memberType", memberType);
		}else {
			memberType = "비정상 가입자";
			req.setAttribute("memberType", memberType);
		}

//		멘토링 검사
		if(memberGrade != -1) {
			mentorType = "X";
			req.setAttribute("mentorType", mentorType);
		}else {
			if(memberVO == null) {
				mentorType = "X";
				req.setAttribute("mentorType", mentorType);
			}else{
				mentorType = "멘토";
				req.setAttribute("mentorType", mentorType);
			}
		}
		
		req.setAttribute("memberName", memberName);
		req.setAttribute("memberLocation", memberLocation);		
		
		return result;
	}
}