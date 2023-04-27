package com.co.kr.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class Pagination {
	
	public static Map<String,Object> pagination(int totalcount, HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		String pnum = (String) session.getAttribute("page");
		System.out.println("pnum"+pnum);
		if (pnum == null) { pnum = "1"; }
		
		int rowNUM = Integer.parseInt(pnum);
		if(rowNUM < 0) {rowNUM = 1;}
		
		int pageNum;
		if (totalcount % 10 == 0) { 
			pageNum = totalcount / 10; 
		}else { 
			pageNum = (totalcount / 10) + 1; 
		}
		if(rowNUM > pageNum) { rowNUM = pageNum; }

		int temp = (rowNUM - 1) % 10;
		int startpage = rowNUM - temp; 
		int endpage = startpage + (10-1); 
		
		if (endpage > pageNum) { endpage = pageNum; } 
		
		int offset = (rowNUM - 1) * 10;
	
		map.put("rowNUM", rowNUM);
		map.put("pageNum", pageNum);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("offset", offset);

		return map;
	}
	
	public static Map<String,Object> uploadPagination(int Gtotal, int pageCount, HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		String pnum = request.getParameter("Gnum");
		if (pnum == null) { pnum = "1"; }
		
		int rowNUM = Integer.parseInt(pnum);
		if(rowNUM < 0) {rowNUM = 1;}
	
		int pageNum;
		if (Gtotal % pageCount == 0) { pageNum = Gtotal / pageCount; 
		} else { 
			pageNum = (Gtotal / pageCount) + 1; 
			}
	
		if(rowNUM > pageNum) { rowNUM = pageNum; }
		
		int temp = (rowNUM - 1) % 10; 
		int startpage = rowNUM - temp;
		int endpage = startpage + 9;
		
		if (endpage > pageNum) { endpage = pageNum; } 
	
		int offset = (rowNUM - 1) * pageCount; 
		map.put("rowNUM", rowNUM);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("pageNum", pageNum);
		map.put("offset", offset);

		return map;
	}
}