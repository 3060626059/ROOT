import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
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
 * Servlet implementation class index 定义servlet的名字,映射路径
 * 
 * 1.程序名字 : 包名+类名 / 包名+类名+自定义 / 包名+自定义 2.映射路径 : 包名+类名 / 包名+类名+自定义 ( . 换成 / )
 * 
 * 
 * 当前servlet是这个项目的默认首页,访问路径 /
 * 
 */
@WebServlet(name = "index_ROOT项目首页", urlPatterns = { "/" })
public class index extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static String x_File_team = "";
	
	public index() {
		super();
		// x_File_team = getServletContext().getRealPath("");
		// 构造器调用时还没有 创建 servlet上下文
		// 构造器是最早被引用
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		x_File_team = getServletContext().getRealPath("");
		// 在这里就可以,因为上下文环境已经创建好了
		// 不想在get中初始化,在这里第一次就不会是空了
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                throws ServletException, IOException {
		
		// 分析请求参数
		Enumeration<String> xParameterNames = request.getParameterNames();
		// 默认没有参数
		// 测试使用 File x_fFile=new File("C:\\Users\\lenovo\\Desktop\\AppProjects\\项目 05-28_搬移\\ROOT\\WebRoot\\index.html");
		if (xParameterNames.hasMoreElements() == false) {
			try {
				// 测试使用 xtool.x_HTML_to_Byte_to_Response(x_fFile, response);
				xtool.x_HTML_to_Byte_to_Response(new File(x_File_team, "index.html"), response);
			} catch (Exception e) {
			}
		} else {
			try {
				xtool.x_HTML_to_Byte_to_Response(
						new StringBuilder()
						.append(x_扫描信息生成网页方法(request))
						.append("<a>")
						.append("测试数据 000-9000-747")
						.append("</a><br>"), 
						response);
			} catch (Exception e) {}
		}
		
	}
	
	public static StringBuilder x_扫描信息生成网页方法(HttpServletRequest request) {
		StringBuilder x_StringBuffer = new StringBuilder();

		// 获取当前项目 应用级 servlet 映射路径
		Map<String, ? extends ServletRegistration> x_servlet登记信息 = request.getServletContext()
		                .getServletRegistrations();
		Iterator<String> x_keyset_iterator = x_servlet登记信息.keySet().iterator();
		while (x_keyset_iterator.hasNext()) {
			String x_keysetL = (String) x_keyset_iterator.next();
			
			if (x_keysetL.equals("default") || x_keysetL.equals("jsp")) {
				continue;
			}
			
			ServletRegistration x_单张_servlet_的登记信息 = x_servlet登记信息.get(x_keysetL);
			
			Collection<String> x_Mappings_映射集合 = x_单张_servlet_的登记信息.getMappings();
			for (String x_映射值 : x_Mappings_映射集合) {
				x_StringBuffer.append("<a href=\"." + x_映射值 + "\">" + x_单张_servlet_的登记信息.getName()+"   :  "+ x_映射值 + "</a><br><br>");
			}
			x_StringBuffer.append("<br>");
			
		}
		return x_StringBuffer;
	}
	
	
}
