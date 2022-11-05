package com.goodTrash.app.driver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goodTrash.app.Result;

public class DriverFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String target = req.getRequestURI().substring(req.getContextPath().length());
		Result result = null;
		
		if(target.equals("/driver/join.driver")) {
			
		}else if(target.equals("/driver/joinOk.driver")) {
			
		}else if(target.equals("/driver/login.driver")) {
			
		}else if(target.equals("/driver/loginOk.driver")) {
			
		}else if(target.equals("/driver/logout.driver")) {
			
		}
		
//		if(result != null) {
//			if(result.isRedirect()) {
//				resp.sendRedirect(result.getPath());
//			}else {
//				req.getRequestDispatcher(result.getPath()).forward(req, resp);
//			}
//		}
	}
}
