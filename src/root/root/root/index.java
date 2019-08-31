package root.root.root;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;


import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.tool.xtool;

@WebServlet(name = "root.root.root.index_古老版本_创建目的忘记了", urlPatterns = { "/root/root/root/index" })
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
    public index() {
    	 /**
    	  * 外部访问路径:x1  
    	  * 
         * 分析请求:
         * 网页请求
         * 视频请求
         * 其它请求
         */
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		Enumeration<String> xParameter = request.getParameterNames();
			
		if (!xParameter.hasMoreElements()) {
			System.out.println("无参数请求");
			x网页请求(request, response, new File("C:\\Users\\lenovo\\Desktop\\AppProjects\\项目 05-28_搬移\\ROOT\\WebRoot\\xtest.html"));
		}else {		
			switch (xParameter.nextElement()) {
			case "x301":
				System.out.println("视频请求!");
				x网页请求(request, response, new File("C:\\Users\\lenovo\\Desktop\\AppProjects\\项目 05-28_搬移\\ROOT\\WebRoot\\xtest.html"));
				//x视频请求(request, response);
				break;

			default:
				//未知情况 直奔首页
				System.out.println("未知情况 直奔首页");
				x网页请求(request, response, new File("C:\\Users\\lenovo\\Desktop\\AppProjects\\项目 05-28_搬移\\ROOT\\WebRoot\\xtest.html"));
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

	protected void x网页请求(HttpServletRequest request ,HttpServletResponse response,File xHTMLFile) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		try {
			ServletOutputStream xout = response.getOutputStream();
			byte[] xHTML = xtool.x读取文本(xHTMLFile);
			response.setContentLengthLong(xHTML.length);
			xout.write(xHTML);
			xout.flush();
			xout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
    protected void x视频请求(HttpServletRequest request ,HttpServletResponse response) {

    	Enumeration<String> xH = request.getHeaderNames();
		System.out.println("xh:");
		while (xH.hasMoreElements()) {
			String xHeaderL = xH.nextElement();
			String xValues = request.getHeader(xHeaderL);
			System.out.println(xHeaderL+":"+xValues);
		}
	}
	
    protected void x其它请求(HttpServletRequest request ,HttpServletResponse response) {
		
	}
    
    
}
