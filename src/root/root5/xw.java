package root.root5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class xw
 */
@WebServlet(name = "root.root5.xw",urlPatterns = {"/root/root5/","/root/root5/xw"})
public class xw extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public xw() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String utf="utf-8";
		request.setCharacterEncoding(utf);
		response.setCharacterEncoding(utf);
		response.setContentType(utf);
		
		//response.getWriter().append("Served a坚果云吐出泰坦虎牙hi t: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.append("<html>" + 
				"<head>" + 
				"<meta  charset=\"UTF-8\">" + 
				"<title>lt sevrlet 页面 </title>" + 
				"</head>" + 
				"<body>" + 
				"");
		
		
		for (int i = 0; i <99; i++) {
			out.append("<a>测试数据:"+i+"</a><br>");
		}

		
		out.append("</body>"
				+"<html>");
		out.close();
		System.out.println("xw被调用了 ");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
