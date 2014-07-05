package com.icrany.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Refresh
 */
public class GetRandomNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRandomNum() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Color getRandomColor(){
    	int r = 0;
    	int g = 0;
    	int b = 0;
    	int border = 255;
    	
    	Random random = new Random();
    	//int seek = random.nextInt(200);
    	r = random.nextInt(border);
    	g = random.nextInt(border);
    	b = random.nextInt(border);
    	
    	return new Color(r,g,b);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma","No-cache"); 
		response.setHeader("Cache-Control","no-cache"); 
		response.setDateHeader("Expires", 0); 
		
		int width = 60;
		int height = 20;
		int border = 200;
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g  = image.getGraphics();
		g.setColor(getRandomColor());
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman",Font.PLAIN,18));
		
		Random random = new Random();
		for(int i = 0;i<50 ;i++){
			g.setColor(getRandomColor());
			
			int x1 =  random.nextInt();
			int x2 = x1+random.nextInt();
			int y1 = random.nextInt();
			int y2 = y1+random.nextInt();
			
			g.drawLine(x1, y1, x2, y2);
		}
		
		String str = "0123456789ABCDEFGHJKLMNPQRSTUVWXYZ";//去掉了字母 O 和 I  
		StringBuilder randomNum = new StringBuilder("");
		int len = 34;
		
		for(int i=1;i<=4;i++){
			int t = random.nextInt(len);
			char a = str.charAt(t);
			randomNum.append(Character.toString(a));
			g.setColor(getRandomColor());
			g.drawString(Character.toString(a), i*10, 16);
		}
		
		HttpSession session = request.getSession();
		String num = randomNum.toString();
		session.setAttribute("randomNum", num);//将结果放置在 session 中了
		System.out.println("randomNum = "+num);
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
		response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
