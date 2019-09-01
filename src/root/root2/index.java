package root.root2;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.tool.xtool;

@WebServlet(name = "root.root2.index_韩顺平教学视频_blibli视频资源",urlPatterns = {"/root/root2/index","/root/root2/"})
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public index() {
	    // 2019年8月31日 17:45:29
	    // 这里的代码有问题
	    // 读取json文件的编码,发送的编码,不统一.
	    // 未解决!
	    
	    
    	//不要把访问路径设置成 / 
	// 因为访问路径是 / 不能访问 js,css,
	// 解决方法是有的, 在 web.xml 设置拦截
	// 默认servlet就会读取js,css,jsp,png
    	//设置成跟服务的话 css js 需要自己写下载代码
        super();
     }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//首页
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");;
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		// ServletOutputStream responseOut = response.getOutputStream(); 
		// 这段代码的功能,在工具包已经封装好,所以不用这样子写了
		Enumeration<String> x请求参数 = request.getParameterNames();
		
		String xtitle="  ---ROOT2 ---韩顺平视频__在线观看  ";
		String x视频请求地址 = null;
		String x图片请求地址 = null;
		
		
		if (x请求参数.hasMoreElements()) {
			switch (x请求参数.nextElement()) {
			case "x600":
				//图片请求
				break;

			case "x200":
				//视频请求  处理方式  请求转发
				request.getRequestDispatcher("/root/root2/fv_root").forward(request, response);
				break;

			case "x300":
				//网页请求  请求目的 :获得含有视频求的网页  处理方式  当前servlet拼接
				String x300 = request.getParameter("x300");

				String x301 = request.getParameter("x301");

				String x302 = request.getParameter("x302");

				String x303 = request.getParameter("x303");//>>页面标题
				//拼接 视频请求路径
				//格式 	 ?x200=23356362&x201=11&x202=lua.flv720.bili2api.64
				x视频请求地址="?x200="+x300+"&x201="+x301+"&x202="+x302;						     			 
				
				 // response.setContentLength(x网页(x303,x视频请求地址,x图片请求地址).toString().length());
				// responseOut.write(x网页(x303,x视频请求地址,x图片请求地址).toString().getBytes(""));
				StringBuilder x_info = x网页(x303,x视频请求地址,x图片请求地址);
					try {
						xtool.x_HTML_to_Byte_to_Response(x_info, response);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				break;

			default:				
				//请求类型  未知  返回首页
				// response.setContentLengthLong(x网页(xtitle, null, x图片请求地址).toString().length());
				// responseOut.write(x网页(xtitle, null, x图片请求地址).toString().getBytes());
				
				StringBuilder x_info1 = x网页(xtitle, null, x图片请求地址);
					try {
						xtool.x_HTML_to_Byte_to_Response(x_info1, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				break;
			}
		}else {
			// response.setContentLengthLong(x网页(xtitle, null, x图片请求地址).toString().length());
			// responseOut.write(x网页(xtitle, null, x图片请求地址).toString().getBytes());
			
			StringBuilder x_info2 = x网页(xtitle, null, x图片请求地址);
			try {
				xtool.x_HTML_to_Byte_to_Response(x_info2, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//responseOut.close();
	}

	public static StringBuilder x网页新标签() {
		StringBuilder xbr=new StringBuilder();
		xbr.append("	<a>这个视频播放项目现在有点问题,部署在tomcat 服务器上播放视频不能播放完整,是视频传输类的问题,我暂时也不会去搞__2019__07__04__14:16</a>" + 
				"	<br>" + 
				"	<br>" + 
				"	<br>" + 
				"");
		return xbr;
	}
	public StringBuilder x播放器(String x视频请求地址,String x图片请求地址) {
		
		StringBuilder sbr = new StringBuilder();
		sbr.append(
				   "<br>"
				+"<video autoplay preload=\"autoplay\" controls=\"controls\" src=\""+x视频请求地址+"\" width=\"98%\" height=\"98%\"></video>\r\n" + 
				"<br>"
				);
		return sbr;
	}
	public  StringBuilder x网页(String x当前页面标题,String x视频请求地址,String x图片请求地址) {
		
		
		String x当前网页资源路径="/./src/";
		// 不要加点就能正确访问资源文件
		StringBuilder x网页内壳=new StringBuilder();
		
		if (x视频请求地址!=null) {
			x网页内壳.append(x播放器(x视频请求地址, x图片请求地址));
			x网页内壳.append(xsc.x信息网页(x当前网页资源路径));
		}else {
			x网页内壳.append(xsc.x信息网页(x当前网页资源路径));
		}
		
		StringBuilder x网页外壳 =new StringBuilder();
			x网页外壳.append("<!DOCTYPE html>" + 
				"<html>" + 
					
				"<head>" + 
				"           <meta charset=\"UTF-8\">" + 
				"           <title>"+x当前页面标题+"</title>"+
				"           <link href=\""+x当前网页资源路径+"css/jquery.treemenu.css\" rel=\"stylesheet\" type=\"text/css\" />"+ 
			    "           <link href=\""+x当前网页资源路径+"css/plpl.css\" rel=\"stylesheet\" type=\"text/css\" />"+ 
				"</head>"+
			    x网页新标签()
			    +	    
			    x网页内壳
				+ "</body></html>");	
		return x网页外壳;
	}
		
		
}
