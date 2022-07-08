package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class AjaxNicknameCheckController
 */
@WebServlet("/nickNameCheck.me")
public class AjaxNicknameCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxNicknameCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkNickName = request.getParameter("checkNickName");
		
		int count = new MemberService().nickNameCheck(checkNickName);
		response.setContentType("text/html; charset=UTF-8");
		
		if(count > 0) { // 존재하는 아이디가 이미 있을 경우 => "NNNNN"
			response.getWriter().print("NNNNN");
		}else if(checkNickName == "") {
			response.getWriter().print("0");
		}
		else { // 존재하는 아이디가 없을 경우 = >"NNNNY"
			response.getWriter().print("NNNNY");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
