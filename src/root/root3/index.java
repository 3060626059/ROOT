package root.root3;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import root.tool.xtool;

/**
 * Servlet implementation class index 扫描当前项目的应用级servlet信息
 * 这个servlet运行会对获取当前请求的共享的上下文环境,
 * 再获取登记信息,得到使用servlet的映射路径
 * 将获取的结果拼接成网页,进行响应.
 */
@WebServlet(name = "root.root3_index_扫描servlet登记信息", urlPatterns = { "/root/root3/index", "/root/root3/" })
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public index() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		// 当前映射将直接返回数据
		StringBuilder x_stringbuilder = x_扫描信息生成网页方法(request);
		try {
			xtool.x_HTML_to_Byte_to_Response(x_stringbuilder, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static StringBuilder x_扫描信息生成网页方法(HttpServletRequest request) {
		StringBuilder x_StringBuffer = new StringBuilder();
		// 下一部分
		x_StringBuffer.append("<a> servlet 登记---路径映射信息</a><br>");
		// 获取当前项目 应用级 servlet 映射路径
		Map<String, ? extends ServletRegistration> x_servlet登记信息 = request.getServletContext()
		                .getServletRegistrations();
		Iterator<String> x_keyset_iterator = x_servlet登记信息.keySet().iterator();
		while (x_keyset_iterator.hasNext()) {
			String x_keysetL = (String) x_keyset_iterator.next();
			
			if (x_keysetL.equals("default") || x_keysetL.equals("jsp")) {
				// 不扫描系统级的servlet
				// System.out.println("对tomcat的系统级servlet,进行跳过处理!");
				continue;
			}
			
			ServletRegistration x_单张_servlet_的登记信息 = x_servlet登记信息.get(x_keysetL);
			
			x_StringBuffer.append("<br><a> ClassName :</a> " + "<a>" + x_单张_servlet_的登记信息.getClassName()
			                + "</a>");
			x_StringBuffer.append("<br><a> Name :</a> " + "<a>" + x_单张_servlet_的登记信息.getName() + "</a>");
			x_StringBuffer.append("<br><a> 映射路径 :</a><br> ");
			Collection<String> x_Mappings_映射集合 = x_单张_servlet_的登记信息.getMappings();
			for (String x_映射值 : x_Mappings_映射集合) {
				x_StringBuffer.append("<a href=\"." + x_映射值 + "\">" + x_映射值 + "</a><br>");
			}
			x_StringBuffer.append("<br><br>");
			
		}
		return x_StringBuffer;
	}
	
}
