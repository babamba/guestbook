package com.bit2016.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.guestbook.dao.GuestBookDao;
import com.bit2016.guestbook.vo.GuestBookVo;


@WebServlet("/gb")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//action name
		
		String actionName = request.getParameter("a");
		System.out.println(actionName);
		if("deleteform".equals(actionName)){
			System.out.println(request.getParameter("no"));
			RequestDispatcher rd = 
					request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
			
		}else if("delete".equals(actionName)){
			String no = request.getParameter( "no" );
			String password = request.getParameter( "password" );
			
			GuestBookVo vo = new GuestBookVo();
			vo.setNo(Long.parseLong( no ));
			vo.setPassword(password);
			
			GuestBookDao dao = new GuestBookDao();
			dao.delete(vo);
			
			response.sendRedirect( "/guestbook2/gb" );
			
		}else if("add".equals(actionName)){

			String name = request.getParameter( "name" );
			String password = request.getParameter( "pass" );
			String content = request.getParameter( "content" );
			System.out.println(name);
			GuestBookVo vo = new GuestBookVo();
			vo.setName(name);
			vo.setContent(content);
			vo.setPassword(password);
			
			GuestBookDao dao = new GuestBookDao();
			dao.insert(vo);
			
			response.sendRedirect( "/guestbook2/gb" );
			
		} else {
			GuestBookDao dao = new GuestBookDao();
			List<GuestBookVo> list = dao.getList();
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);  //post방식할때  꼭있어야함
	}

}
