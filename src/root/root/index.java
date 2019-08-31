package root.root;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.tool.xtool;


@WebServlet(name = "root.root.测试_响应网页",urlPatterns = { "/root/root/index"})
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public index() {
        super();
        //读取一个html 文件
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {	
		
		xtool.x请求信息(request);
		
		response.setCharacterEncoding("utf-8");
		
		if (!request.getParameterNames().hasMoreElements()) {
			//没有参数的请求
			x网页响应(request, response);
		}else {
			//资源请求
			x其它响应(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

	protected static void x网页响应(HttpServletRequest request,HttpServletResponse response) {
		File xindex=new File("C:\\Users\\lenovo\\Desktop\\AppProjects\\项目 05-28_搬移\\ROOT\\WebRoot\\xg.html");
		if (!xindex.exists()) {
			//设置404响应码
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}else {
			response.setStatus(200);
		}
			
		ServletOutputStream xout = null ;
		FileInputStream xin = null;
		try {
			
			xout = response.getOutputStream();
			xin = new FileInputStream(xindex);
			int x缓冲长度=xin.available();
			byte[] xbs = new byte[x缓冲长度];
			             xin.read(xbs);
				         xout.write(xbs);	         
		} catch (IOException e) {e.printStackTrace();}
		finally {
			if (xin!=null||xout!=null) {
				try {
					xout.close();
					xin.close();
				} catch (IOException e) {}
			}
		}
		//这一段主要是 响应网页
		xtool.x响应信息(response);
	}
	
	protected static void x其它响应(HttpServletRequest request,HttpServletResponse response) {
		//因为是由servlet发出的网页,该网页的资源请求就是由servlet接手
		Enumeration<String> xParameter = request.getParameterNames();
		switch (xParameter.nextElement()) {
		case "filename":
			try {
				//下载任务进行请求转发
				request.getRequestDispatcher("/x下载与上传").forward(request, response);
				//request.getRequestDispatcher("").include(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		default:
			x网页响应(request, response);
			break;
		}
	}
}
