package com.goodTrash.app.garbageCollect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goodTrash.app.Result;

public class GarbageCollectFrontController extends HttpServlet{
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
		
//		예약 매인 페이지
		if(target.equals("/garbageCollect/request.collect")) {
			result = new Result();
			result.setPath("/app/garbageCollect/request.jsp");
			
//		신청 페이지
		}else if(target.equals("/garbageCollect/reservation.collect")) {
			result = new Result();
			result.setPath("/app/garbageCollect/reservation.jsp");
			
//		신청 완료
		}else if(target.equals("/garbageCollect/reservationOk.collect")) {
			result = new ReservationOkController().execute(req, resp);
		
//		예약리스트 페이지
		}else if(target.equals("/garbageCollect/history.collect")) {
			result = new HistoryListOkController().execute(req, resp);
		
//		예약디테일 페이지 
		}else if(target.equals("/garbageCollect/requestCheckDetail.collect")) {
			result = new RequestCheckDetailController().execute(req, resp);
		
//		예약 삭제
		}else if(target.equals("/garbageCollect/requestDelete.collect")) {
			result = new RequestDeleteController().execute(req, resp);
		}
		
		
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			}else {
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
			
		}
	
	}
}
