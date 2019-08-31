package root.root4;


import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class 绝密消息
 */
@WebServlet(name = "root.root4.绝密消息",urlPatterns = {"/root/root4/","/root/root4/绝密消息"})
public class 绝密消息 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public 绝密消息() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest x请求, HttpServletResponse x响应) throws ServletException, IOException {

		String xutf_8="utf-8";
		
		x请求.setCharacterEncoding(xutf_8);
		x响应.setCharacterEncoding(xutf_8);
		x响应.setContentType(xutf_8);
		
		//普通请求  
		   Enumeration<String> x普通请求参数 = x请求.getParameterNames();
		  
		   StringBuilder x信息=new StringBuilder();
		   while (x普通请求参数.hasMoreElements()) {
			String string = (String) x普通请求参数.nextElement();
	         String xtmp = x请求.getHeader(string);
	         //x请求.get
			x信息.append("\n\n 为什么没有信息 "+
	         string+
	         "    "+
	         ""+
	         xtmp);
		}
		
		//其它请求 有参数
		
		
		
		x响应.getWriter().append("<!DOCTYPE html>" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"UTF-8\">" + 
				"<title>惊天大秘密</title>" + 
				"</head>" + 
				"<body>" + 
				"<a>你能保证不告诉其它人吗? 能相信你吗?</a>" +//不打算相信
				"<a>"+
				x信息+
				"</a>"+ 
				"<br>"+
				"</boby>"+
				"</html>");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
