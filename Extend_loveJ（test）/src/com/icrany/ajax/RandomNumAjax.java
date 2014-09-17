package com.icrany.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author <a href="http://www.icrany.com">iCrany</a>
 * 2014年8月27日 下午10:58:24
 */
public class RandomNumAjax extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomNumAjax() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String randomNum = request.getParameter("randomNum");
		String randomNumInSession = (String)request.getSession().getAttribute("randomNum");
		
		System.out.println("in RandomNumAjax randomNum = " +randomNum);
		System.out.println("in RandomNumAjax randomNumInSession = " +randomNumInSession);
		
		if(randomNumInSession.equals(randomNum)){
			response.getWriter().write("true");
		}
		else{
			response.getWriter().write("false");
		}
		
		
	}

}
